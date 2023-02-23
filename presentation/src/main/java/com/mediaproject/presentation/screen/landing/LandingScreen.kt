package com.mediaproject.presentation.screen.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.ivory1
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun LandingScreen(modifier: Modifier = Modifier, onTimeout: () -> Unit) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(
            color = ivory1
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
    Image(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
        painter = painterResource(
            id = R.drawable.logo_rerollbag
        ),
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(onTimeout = {})
}