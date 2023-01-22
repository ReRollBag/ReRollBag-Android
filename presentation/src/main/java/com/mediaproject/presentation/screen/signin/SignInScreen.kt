package com.mediaproject.presentation.screen.signin

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.widgets.states.SignInState
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel(),
    onSuccessSignIn: () -> Unit = {},
    onSignUpBtnClick: () -> Unit,
) {
    val signInState = viewModel.signInState.observeAsState()
    var userId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        when (signInState.value) {
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
                    Image(
                        modifier = Modifier
                            .height(32.dp)
                            .fillMaxWidth(),
                        painter = painterResource(id = R.drawable.logo_rerollbag),
                        contentDescription = "ReRollBag"
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    ReRollBagTextField(
                        value = userId,
                        onValueChange = { newValue ->
                            userId = newValue
                        },
                        hint = "아이디",
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    ReRollBagTextField(
                        value = password,
                        onValueChange = { newValue ->
                            password = newValue
                        },
                        hint = "비밀번호",
                        isPassword = true,
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        modifier = modifier
                            .height(44.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(25.dp),
                        onClick = {
                            viewModel.signIn(
                                userId = userId,
                                password = password
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = green1,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "로그인")
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
                        )
                    ) {
                        Text(text = "회원가입")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(
        onSignUpBtnClick = { Log.d("[SignIn]", "onClick SignUpBtn") }
    )
}
