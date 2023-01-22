package com.mediaproject.presentation.common.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.R

// region const value field
private val TextFieldHeight: Dp = 40.dp
private val DefaultTextFieldRound: Dp = 0.dp
private val BasicTextFieldStartPadding = 0.dp
// endregion

@Composable
fun ReRollBagTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (newValue: String) -> Unit,
    backgroundColor: Color = Color.White,
    title: String? = null,
    hint: String? = null,
    hintBackgroundColor: Color? = Color.Transparent,
    enabledSideBtn: Boolean = false,
    sideBtnText: String? = null,
    round: Dp = DefaultTextFieldRound,
    onSideBtnClick: (() -> Unit)? = null,
    error: String? = null,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    description: String? = null,
    singleLine: Boolean = true,
) {

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier,
    ) {
        if (!title.isNullOrEmpty()) {
            // title
        }

        Box(
           modifier = Modifier
               .heightIn(TextFieldHeight)
               .wrapContentHeight(Alignment.CenterVertically)
               .background(
                   color = backgroundColor,
                   shape = RoundedCornerShape(round)
               )
        ) {
            RRBBasicTextField(
                value = value,
                onValueChange = onValueChange,
                hint = hint,
                passwordVisible = passwordVisible,
                onPasswordVisibleChanged = {
                    passwordVisible = it
                },
                enabledSideBtn = enabledSideBtn,
                sideBtnText = sideBtnText,
                round = round,
                onSideBtnClick = onSideBtnClick,
                isPassword = isPassword,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction,
                ),
                singleLine = singleLine,
            )
        }

    }


}

@Composable
private fun RRBBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    passwordVisible: Boolean = false,
    onPasswordVisibleChanged: (Boolean) -> Unit,
    enabledSideBtn: Boolean = false,
    sideBtnText: String? = null,
    round: Dp = DefaultTextFieldRound,
    onSideBtnClick: (() -> Unit)? = null,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Default,
    ),
    singleLine: Boolean = true,
) {
    BasicTextField(
        modifier = Modifier
//            .height(TextFieldHeight)
            .fillMaxWidth()
            .padding(start = BasicTextFieldStartPadding),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        visualTransformation = if (!passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        maxLines = 1,
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 19.sp,
        ),
        decorationBox = @Composable { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
            ) {
                innerTextField()

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (value.isEmpty() && hint != null) {
                        Text(hint)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    if (isPassword) {
                        Image(
                            modifier = Modifier.clickable { onPasswordVisibleChanged(!passwordVisible) },
                            painter = painterResource(
                                when (passwordVisible) {
                                    true -> R.drawable.ic_clarity_eye_show
                                    false -> R.drawable.ic_clarity_eye_hide
                                }
                            ),
                            contentDescription = "IC_PASSWORD_VISIBLE",
                        )
                    }

                    Spacer(modifier = Modifier.width(9.dp))

                }
            }
        },
    )
}

@Preview
@Composable
fun PreviewReRollBagTextField() {
    var value by remember { mutableStateOf<String?>(null) }
    var value2 by remember { mutableStateOf<String?>(null) }
    var value3 by remember { mutableStateOf<String?>(null) }

    Column(
//        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // default text field
        ReRollBagTextField(
            value = value ?: "asdas",
            onValueChange = { value = it },
            error = null
        )

        // password text field
        ReRollBagTextField(
            value = value2 ?: "dasds",
            onValueChange = { value2 = it },
            isPassword = true
        )

        // error text field
        ReRollBagTextField(
            value = value3 ?: "",
            onValueChange = { value3 = it },
            error = "특수문자는 사용할 수 없습니다!"
        )

    }
}