package com.mediaproject.presentation.common.nav

import android.content.Context
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.presentation.common.route.HomeScreenRoute
import com.mediaproject.presentation.screen.home.menu.HomeMenuScreen
import com.mediaproject.presentation.screen.home.HomeScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController,
    context: Context,
    onClickQrScan: () -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute.Home.route
    ) {
        composable(route = HomeScreenRoute.Home.route) {
            HomeScreen(
                onClickQrScan = onClickQrScan
            ) {
                navController.navigate(HomeScreenRoute.HomeMenu.route)
            }
        }
        composable(route = HomeScreenRoute.HomeMenu.route) {
            HomeMenuScreen {
                navController.popBackStack()
            }
        }
    }
}