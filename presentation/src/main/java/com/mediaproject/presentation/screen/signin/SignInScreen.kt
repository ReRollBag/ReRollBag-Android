package com.mediaproject.presentation.screen.signin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import com.mediaproject.presentation.widgets.states.SignInState

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel(),
    onSignInBtnClick: () -> Unit,
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
            else -> {
                Column {
                    TextField(
                        value = userId,
                        onValueChange = {
                            userId = it
                        },
                        label = { Text("Email") }
                    )
                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        label = { Text("Password") }
                    )
                    Button(onClick = onSignInBtnClick) {
                        Text(text = "SignIn")
                    }
                    Button(onClick = {
                        viewModel.signIn("test", "test1234")
                    }) {
                        Text(text = "Test SignIn")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(onSignInBtnClick = { Log.d("[SignIn]", "onClick SignUpBtn") })
}