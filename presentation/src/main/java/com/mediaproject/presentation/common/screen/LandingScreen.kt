package com.mediaproject.presentation.common.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.Purple80
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun LandingScreen(modifier: Modifier = Modifier, onTimeout: () -> Unit) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(
            color = Purple80
        ),
    contentAlignment = Alignment.Center
) {
    val currentOnTimeout by rememberUpdatedState(onTimeout)

//        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
//        val logoAnimationState =
//            animateLottieCompositionAsState(composition = composition)
//        LottieAnimation(
//            composition = composition,
//            progress = { logoAnimationState.progress }
//        )
//        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
//        }

    LaunchedEffect(onTimeout) {
        delay(SplashWaitTime) // Simulates loading things
        currentOnTimeout()
    }
    Image(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(onTimeout = {})
}