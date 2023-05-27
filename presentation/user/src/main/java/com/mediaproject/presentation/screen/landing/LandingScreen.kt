package com.mediaproject.presentation.screen.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.R
import com.mediaproject.presentation.screen.vm.SignInViewModel
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel(),
    onTimeoutUserHome: () -> Unit,
    onTimeoutAdminHome: () -> Unit,
    onTimeoutSignIn: () -> Unit,
) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(
//            color = ivory1
            color = Color.White
        ),
    contentAlignment = Alignment.Center
) {
    val currentOnTimeoutUserHome by rememberUpdatedState(onTimeoutUserHome)
    val currentOnTimeoutAdminHome by rememberUpdatedState(onTimeoutAdminHome)
    val currentOnTimeoutSignIn by rememberUpdatedState(onTimeoutSignIn)
    val isAlreadyLogin = viewModel.alreadyLogin.observeAsState()
//        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
//        val logoAnimationState =
//            animateLottieCompositionAsState(composition = composition)
//        LottieAnimation(
//            composition = composition,
//            progress = { logoAnimationState.progress }
//        )
//        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
//        }

    if (isAlreadyLogin.value != null) {
        when (isAlreadyLogin.value!!) {
            true -> when (viewModel.adminLogin.value!!) {
                true -> LaunchedEffect(onTimeoutAdminHome) {
                    delay(SplashWaitTime) // Simulates loading things
                    currentOnTimeoutAdminHome()
                }
                false -> LaunchedEffect(onTimeoutUserHome) {
                    delay(SplashWaitTime) // Simulates loading things
                    currentOnTimeoutUserHome()
                }
            }
            false -> LaunchedEffect(onTimeoutSignIn) {
                delay(SplashWaitTime) // Simulates loading things
                currentOnTimeoutSignIn()
            }
        }
    }

    LandingScreenBody()
}

@Composable
fun LandingScreenBody() {
    Image(
        modifier = Modifier,
        painter = painterResource(
            id = R.drawable.logo_rerollbag
        ),
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
//                color = ivory1,
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        LandingScreenBody()
    }
}