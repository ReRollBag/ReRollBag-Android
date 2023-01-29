package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.notoSansFamily
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpEmailView(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
) {
    var userId by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            "이메일",
            style = TextStyle(
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.widthIn(max = 200.dp)
            ) {
                ReRollBagTextField(
                    value = userId,
                    onValueChange = {
                        userId = it
                    }
                )
                Divider(color = isEmailSuccessColor(uiState), thickness = 1.dp)
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                modifier = Modifier
                    .width(100.dp),
                border = BorderStroke(
                    1.dp,
                    isEmailSuccessColor(uiState)
                ),
                shape = RoundedCornerShape(25.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = isEmailSuccessColor(uiState)
                ),
            ) {
                Text(
                    text = "중복확인",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 0.sp,
                    ),
                    modifier = Modifier.height(20.dp)
                )
            }
        }
    }
}

private fun isEmailSuccessColor(uiState: SignUpState?) = when (uiState) {
    is SignUpState.SignUpError -> Color.Red
    is SignUpState.DuplicateCheckSuccess -> if (uiState.isExistUserId) green1 else gray2
    else -> gray2
}

@Preview(
    showBackground = true,
)
@Composable
fun SignUpEmailViewPreview() {
    SignUpEmailView(
        uiState = SignUpState.SignUpInit
    )
}