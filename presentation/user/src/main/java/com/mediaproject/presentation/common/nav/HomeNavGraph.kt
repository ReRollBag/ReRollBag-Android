package com.mediaproject.presentation.common.nav

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.presentation.common.route.UserHomeScreenRoute
import com.mediaproject.presentation.screen.landing.LandingActivity
import com.mediaproject.presentation.screen.user.home.UserHomeScreen
import com.mediaproject.presentation.screen.user.home.menu.UserHomeMenuScreen
import com.mediaproject.presentation.screen.user.notice.NoticeScreen
import com.mediaproject.presentation.screen.user.rent.RentListScreen
import com.mediaproject.presentation.screen.vm.BagViewModel
import com.mediaproject.presentation.screen.vm.MapViewModel

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
        startDestination = UserHomeScreenRoute.Home.route
    ) {
        composable(route = UserHomeScreenRoute.Home.route) {
            UserHomeScreen(
                onClickQrScan = onClickQrScan,
                mapViewModel = mapViewModel,
                bagViewModel = bagViewModel,
                onClickNotice = {
                    navController.navigate(UserHomeScreenRoute.Notice.route)
                },
            ) {
                navController.navigate(UserHomeScreenRoute.HomeMenu.route)
            }
        }
        composable(route = UserHomeScreenRoute.HomeMenu.route) {
            UserHomeMenuScreen(
                modifier = Modifier.background(color = Color.White),
                onSignOut = {
                    context.startActivity(
                        Intent(context, LandingActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                },
                onClickRentList = {
                    navController.navigate(UserHomeScreenRoute.RentList.route)
                },
                onClickNotice = {
                    navController.navigate(UserHomeScreenRoute.Notice.route)
                }
            ) {
                navController.popBackStack()
            }
        }
        composable(route = UserHomeScreenRoute.RentList.route) {
            RentListScreen {
                navController.popBackStack()
            }
        }
        composable(route = UserHomeScreenRoute.Notice.route) {
            NoticeScreen {
                navController.popBackStack()
            }
        }
    }
}