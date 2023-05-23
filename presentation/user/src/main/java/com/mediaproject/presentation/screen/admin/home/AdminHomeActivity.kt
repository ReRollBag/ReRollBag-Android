package com.mediaproject.presentation.screen.admin.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mediaproject.presentation.common.nav.AdminHomeNavGraph
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminHomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReRollBagTheme {
                val navController = rememberNavController()
                AdminHomeNavGraph(
                    navController = navController,
                    context = applicationContext,
                )
            }
        }
    }

}