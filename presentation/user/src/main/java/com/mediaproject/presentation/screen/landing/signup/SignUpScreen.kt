package com.mediaproject.presentation.screen.landing.signup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.screen.vm.SignUpViewModel
import com.mediaproject.presentation.widgets.states.SignUpState

private const val TAG = "SignUpScreen"

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    isSocial: Boolean = false,
    viewModel: SignUpViewModel = hiltViewModel(),
    onBackPress: () -> Unit = {},
    onSuccessSignUp: () -> Unit = {},
) {
    val signUpState = viewModel.signUpState.observeAsState()
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    when (signUpState.value) {
        is SignUpState.SignUpLoading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        is SignUpState.SignUpSuccess -> {
            onSuccessSignUp()
        }
        else -> {
            SignUpScreenContent(
                modifier = modifier
                    .background(color = Color.White)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        focusManager.clearFocus()
                    },
                uiState = signUpState.value,
                isSocial = isSocial,
                onBackPress = onBackPress,
            )
        }
    }
}

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
    viewModel: SignUpViewModel = hiltViewModel(),
    isSocial: Boolean = false,
    onBackPress: () -> Unit = {},
) = Scaffold(
    topBar = { SignUpAppBarView(onBackPress = onBackPress) },
    bottomBar = {
        SignUpScreenBottomBar(
            modifier = modifier,
            uiState = uiState
        ) {
            viewModel.signUp(data = uiState!!.data)
        }
    },
) { padding ->
    SignUpScreenBody(
        modifier = modifier
            .padding(padding),
        uiState = uiState,
        isSocial = isSocial,
        onChangeEmail = { viewModel.changeEmail(it) },
        onDuplicateCheckUserId = { viewModel.duplicateCheckUserId(it) },
        onRefreshCheck = { viewModel.refreshCheck(it) },
        onChangePassword = { viewModel.changePassword(it) },
        onChangePasswordChecker = { viewModel.changePasswordChecker(it) },
        onChangeName = { viewModel.changeName(it) },
    )
}