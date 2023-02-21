package com.mediaproject.presentation.screen.signup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.widgets.states.SignUpData
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
    onBackPress: () -> Unit = {},
) {
    val signUpState = viewModel.signUpState.observeAsState()
    val focusManager = LocalFocusManager.current
    SignUpScreenContent(
        modifier = modifier.clickable { focusManager.clearFocus() },
        uiState = signUpState.value,
        onBackPress = onBackPress
    )
}

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
    viewModel: SignUpViewModel = hiltViewModel(),
    onBackPress: () -> Unit = {},
) = Scaffold(
    topBar = {
        SignUpAppBarView(
            onBackPress = onBackPress
        )
    },
    bottomBar = {
        val isEnable: Boolean = (
            uiState!!.data.isExistUserId
            && uiState.data.password == uiState.data.passwordCheckStr
            && checkAll(uiState.data.password)
            && uiState.data.name.isNotEmpty()
        )

        Box(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp)
                .background(gray1),
            contentAlignment = Alignment.Center,
        ) {
            Log.d("TAG", "Refresh $isEnable")
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 80.dp),
                onClick = {
                    viewModel.signUp(
                        data = SignUpData(
                            userId = "test@gmail.com",
                            isExistUserId = true,
                            password = "test1234",
                            passwordCheckStr = "test1234",
                            name = "테스트",
                        )
                    )
                },
                colors = if (isEnable) ButtonDefaults.buttonColors(backgroundColor = green1) else ButtonDefaults.buttonColors(backgroundColor = gray1),
                enabled = isEnable,
            ) {
                Text("가입")
            }
        }
    }
) { padding ->
    SignUpScreenBody(
        modifier = modifier
            .padding(padding),
        uiState = uiState,
        viewModel = viewModel,
    )
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
fun SignUpScreenContentPreview() {
    SignUpScreenContent(
        uiState = SignUpState.UpdateData(
            state = SignUpData(
                userId = "test@gmail.com",
                isExistUserId = true,
                password = "test1234",
                passwordCheckStr = "test1234",
                name = "테스트",
            ),
        )
    )
}