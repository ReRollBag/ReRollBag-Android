package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.notoSansFamily
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
    onBackPress: () -> Unit = {},
) {
    val signUpState = viewModel.signUpState.observeAsState()
    SignUpScreenContent(
        uiState = signUpState.value,
        onBackPress = onBackPress,
        onCheckUserIdDuplicateClick = {
            viewModel.duplicateCheckUserId(
                userId = "test",
                isExistUserId = false,
                nickname = "test",
                isExistNickname = false,
                password = "test1234"
            )
        },
        onCheckNicknameDuplicateClick = {
            viewModel.duplicateCheckUserId(
                userId = "test",
                isExistUserId = false,
                nickname = "test",
                isExistNickname = false,
                password = "test1234"
            )
        },
        onSignUpClick = {
            viewModel.signUp(
                userId = "test",
                isExistUserId = true,
                nickname = "test",
                isExistNickname = true,
                password = "test1234"
            )
        }
    )
}

@Composable
fun SignUpScreenContent(
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
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            SignUpAppBarView(
                onBackPress = onBackPress
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 30.dp,
                        vertical = 8.dp
                    ),
            ) {
                // region Email
                Column(
                    modifier = Modifier
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
                        modifier = Modifier
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
                                .width(100.dp)
                                .wrapContentHeight(),
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
                // endregion

                Spacer(modifier = Modifier.height(30.dp))

                // region Password
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        "비밀번호",
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
                                isPassword = true
                            )
                            Divider(color = gray1, thickness = 1.dp)
                        }
                    }
                }
                // endregion

                Spacer(modifier = Modifier.height(30.dp))

                // region Password Check
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        "비밀번호 확인",
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
                                isPassword = true
                            )
                            Divider(color = gray1, thickness = 1.dp)
                        }
                    }
                }
                // endregion

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
                            Divider(color = gray1, thickness = 1.dp)
                        }
                    }
                }
                // endregion


            }

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 80.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text("가입")
            }
        }
    }
}

private fun isEmailSuccessColor(uiState: SignUpState?) = when (uiState) {
    is SignUpState.SignUpError -> Color.Red
    is SignUpState.DuplicateCheckSuccess -> if (uiState.isExistUserId) green1 else gray1
    else -> gray2
}

@Composable
fun SignUpEmailView() {

}

@Preview(
//    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
fun SignUpScreenContentPreview() {
    SignUpScreenContent(
        uiState = SignUpState.DuplicateCheckSuccess(
            userId = "test",
            isExistUserId = true,
            password = "",
            nickname = "",
            isExistNickname = false,
            userRole = ""
        )
    )
}