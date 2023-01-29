package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
) = Scaffold(
    topBar = {
        SignUpAppBarView(
            onBackPress = onBackPress
        )
    },
    bottomBar = {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text("가입")
        }
    }
) { padding ->
    SignUpScreenBody(
        modifier = modifier
            .padding(padding),
        uiState = uiState,
        onBackPress = onBackPress,
        onCheckUserIdDuplicateClick = onCheckUserIdDuplicateClick,
        onCheckNicknameDuplicateClick = onCheckNicknameDuplicateClick,
        onSignUpClick = onSignUpClick,
    )
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
fun SignUpScreenContentPreview() {
    SignUpScreenContent(
//        uiState = SignUpState.DuplicateCheckSuccess(
//            userId = "test",
//            isExistUserId = true,
//            password = "",
//            nickname = "",
//            isExistNickname = false,
//            userRole = ""
//        )
        uiState = SignUpState.SignUpInit
    )
}