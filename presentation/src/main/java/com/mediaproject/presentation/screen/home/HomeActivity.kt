package com.mediaproject.presentation.screen.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mediaproject.presentation.common.nav.HomeNavGraph
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEmpty

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReRollBagTheme {
                val navController = rememberNavController()
                HomeNavGraph(
                    navController = navController,
                    context = applicationContext,
                )
            }
        }

    }

}