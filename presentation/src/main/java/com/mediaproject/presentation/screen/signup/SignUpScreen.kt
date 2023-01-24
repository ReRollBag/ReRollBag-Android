package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
    onBackPress: () -> Unit = {},
) {
    val signUpState = viewModel.signUpState.observeAsState()
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
            Button(
                onClick = {
                    viewModel.duplicateCheckUserId(
                        userId = "test",
                        isExistUserId = false,
                        nickname = "test",
                        isExistNickname = false,
                        password = "test1234"
                    )
                }
            ) {
                Text(text = "Test UserId check")
            }
            Button(
                onClick = {
                    viewModel.duplicateCheckUserId(
                        userId = "test",
                        isExistUserId = false,
                        nickname = "test",
                        isExistNickname = false,
                        password = "test1234"
                    )
                }
            ) {
                Text(text = "Test Nickname check")
            }
            Button(
                onClick = {
                    viewModel.signUp(
                        userId = "test",
                        isExistUserId = true,
                        nickname = "test",
                        isExistNickname = true,
                        password = "test1234"
                    )
                }
            ) {
                Text(text = "Test SignUp")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}