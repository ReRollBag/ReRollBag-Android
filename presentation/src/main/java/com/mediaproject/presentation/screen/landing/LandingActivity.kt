package com.mediaproject.presentation.screen.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mediaproject.presentation.common.nav.LandingNavGraph
import com.mediaproject.presentation.common.theme.AnimatedSplashScreenTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnimatedSplashScreenTheme {
                val navController = rememberNavController()
                LandingNavGraph(navController = navController, context = applicationContext)
            }
        }
    }
}