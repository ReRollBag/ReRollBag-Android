package com.mediaproject.presentation.common.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.presentation.common.route.AdminHomeScreenRoute

@Composable
fun AdminHomeNavGraph(
    navController: NavHostController,
    context: Context,
) {
    NavHost(
        navController = navController,
        startDestination = AdminHomeScreenRoute.Home.route
    ) {
        composable(route = AdminHomeScreenRoute.Home.route) {
        }
    }
}