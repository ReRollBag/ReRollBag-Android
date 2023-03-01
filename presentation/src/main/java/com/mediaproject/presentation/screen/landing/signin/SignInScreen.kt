package com.mediaproject.presentation.screen.landing.signin

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.ReRollBagTypography
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.screen.vm.SignInViewModel
import com.mediaproject.presentation.widgets.states.SignInState

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel(),
    onSuccessSignIn: () -> Unit = {},
    onSignUpBtnClick: () -> Unit = {},
    onSocialSignUp: () -> Unit = {},
) {
    val signInState = viewModel.signInState.observeAsState()
    val focusManager = LocalFocusManager.current
    SignInContentView(
        modifier = modifier.clickable {
            focusManager.clearFocus()
        },
        uiState = signInState.value,
        onSignInClick = { userId, password ->
            viewModel.signIn(
                userId = userId,
                password = password
            )
        },
        onSuccessSignIn = onSuccessSignIn,
        onSignUpBtnClick = onSignUpBtnClick,
    )
}

@Composable
fun SignInContentView(
    modifier: Modifier = Modifier,
    uiState: SignInState?,
    onSignInClick: (userId: String, password: String) -> Unit = { _, _ -> },
    onSuccessSignIn: () -> Unit = {},
    onSignUpBtnClick: () -> Unit = {},
) {
    var userId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is SignInState.SignInLoading -> {
                CircularProgressIndicator()
            }
            is SignInState.SignInSuccess -> {
                onSuccessSignIn()
            }
            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SignInLogoScreen()
                    Spacer(modifier = Modifier.height(60.dp))
                    ReRollBagTextField(
                        value = userId,
                        onValueChange = { newValue ->
                            userId = newValue
                        },
                        hint = "아이디",
                    )
                    Divider(color = gray1, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(30.dp))
                    ReRollBagTextField(
                        value = password,
                        onValueChange = { newValue ->
                            password = newValue
                        },
                        hint = "비밀번호",
                        isPassword = true,
                    )
                    Divider(color = gray1, thickness = 1.dp)
                    if (uiState is SignInState.SignInError) {
                        SignInErrorScreen(
                            condition = true,
                            errorMessage = uiState.errorMessage
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        modifier = modifier
                            .height(44.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        onClick = { onSignInClick(userId, password) },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = green1,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "로그인",
                            style = TextStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 13.sp,
                                lineHeight = 17.sp
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = modifier
                            .height(44.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        border = BorderStroke(2.dp, green1),
                        onClick = onSignUpBtnClick,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = green1
                        ),
                    ) {
                        Text(
                            text = "회원가입",
                            style = TextStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 13.sp,
                                lineHeight = 17.sp
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "SNS 계정으로 로그인",
                        style = TextStyle(
                            fontWeight = FontWeight(700),
                            fontSize = 13.sp,
                            lineHeight = 19.sp
                        ),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_naver_logo),
                                contentDescription = "naver",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        Log.d("Naver", "Naver Login Click")
                                    }
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "네이버 로그인",
                                style = ReRollBagTypography.title3,
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_kakao_logo),
                                contentDescription = "kakao",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        Log.d("kakao", "kakao Login Click")
                                    }
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "카카오 로그인",
                                style = ReRollBagTypography.title3,
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_google_logo),
                                contentDescription = "google",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        Log.d("google", "google Login Click")
                                    }
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "구글 로그인",
                                style = ReRollBagTypography.title3,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    val screenCase = 1

    when (screenCase) {
        1 ->  {
            SignInContentView(
                uiState = SignInState.SignInError(
                    userId = "",
                    password = "",
                    errorMessage = "UsersIdOrPasswordInvalidException"
                )
            )
        }
        2 -> {
            SignInContentView(
                uiState = SignInState.SignInError(
                    userId = "",
                    password = "",
                    errorMessage = ""
                )
            )
        }
        else -> {
            SignInContentView(
                uiState = SignInState.SignInInit
            )
        }
    }
}
