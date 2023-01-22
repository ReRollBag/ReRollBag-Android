package com.mediaproject.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mediaproject.presentation.common.nav.SetupNavGraph
import com.mediaproject.presentation.common.theme.AnimatedSplashScreenTheme
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReRollBagTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}