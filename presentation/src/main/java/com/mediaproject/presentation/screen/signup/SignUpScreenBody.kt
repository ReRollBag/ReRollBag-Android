package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
fun SignUpScreenBody(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
    onBackPress: () -> Unit = {},
    onCheckUserIdDuplicateClick: () -> Unit = {},
    onCheckNicknameDuplicateClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
) {
    var userId by rememberSaveable { mutableStateOf("") }
    var isExistUserId by rememberSaveable { mutableStateOf(false) }
    var nickname by rememberSaveable { mutableStateOf("") }
    var isExistNickname by rememberSaveable { mutableStateOf(false) }


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 30.dp,
                    vertical = 8.dp
                ),
        ) {
            SignUpEmailView(uiState = uiState)

            Spacer(modifier = Modifier.height(30.dp))

            SignUpPasswordView(uiState = uiState)

            Spacer(modifier = Modifier.height(30.dp))

            // region name
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "이름",
                    style = TextStyle(
                        fontFamily = notoSansFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ReRollBagTextField(
                            value = userId,
                            onValueChange = {
                                userId = it
                            },
                        )
                        Divider(color = gray2, thickness = 1.dp)
                    }
                }
            }
            // endregion


        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SignUpScreenBodyPreview() {
    SignUpScreenBody(
        uiState = SignUpState.SignUpInit
    )
}