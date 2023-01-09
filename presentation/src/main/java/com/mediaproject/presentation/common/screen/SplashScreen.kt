package com.mediaproject.presentation.common.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mediaproject.presentation.common.theme.Purple80
import com.mediaproject.presentation.screen.signin.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Purple80
            )
    ) {
//        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
//        val logoAnimationState =
//            animateLottieCompositionAsState(composition = composition)
//        LottieAnimation(
//            composition = composition,
//            progress = { logoAnimationState.progress }
//        )
//        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
//        }

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            navController.navigate(Screen.Home.route)
        }
    }
}