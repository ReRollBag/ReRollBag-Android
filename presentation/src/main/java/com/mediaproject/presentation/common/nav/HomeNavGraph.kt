package com.mediaproject.presentation.common.nav

import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.presentation.common.route.HomeScreenRoute
import com.mediaproject.presentation.screen.home.HomeActivity
import com.mediaproject.presentation.screen.home.menu.HomeMenuScreen
import com.mediaproject.presentation.screen.home.HomeScreen
import com.mediaproject.presentation.screen.landing.LandingActivity
import com.mediaproject.presentation.screen.rent.RentListScreen
import com.mediaproject.presentation.screen.vm.BagViewModel
import com.mediaproject.presentation.screen.vm.MapViewModel
import com.mediaproject.presentation.screen.vm.RentListViewModel

@Composable
fun HomeNavGraph(
    navController: NavHostController,
    context: Context,
    mapViewModel: MapViewModel = hiltViewModel(),
    bagViewModel: BagViewModel = hiltViewModel(),
    onClickQrScan: () -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute.Home.route
    ) {
        composable(route = HomeScreenRoute.Home.route) {
            HomeScreen(
                onClickQrScan = onClickQrScan,
                mapViewModel = mapViewModel,
                bagViewModel = bagViewModel
            ) {
                navController.navigate(HomeScreenRoute.HomeMenu.route)
            }
        }
        composable(route = HomeScreenRoute.HomeMenu.route) {
            HomeMenuScreen(
                modifier = Modifier.background(color = Color.White),
                onSignOut = {
                    context.startActivity(
                        Intent(context, LandingActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                },
                onClickRentList = {
                    navController.navigate(HomeScreenRoute.RentList.route)
                }
            ) {
                navController.popBackStack()
            }
        }
        composable(route = HomeScreenRoute.RentList.route) {
            RentListScreen() {
                navController.popBackStack()
            }
        }
    }
}