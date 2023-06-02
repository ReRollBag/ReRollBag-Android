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
import com.mediaproject.presentation.common.route.AdminHomeScreenRoute
import com.mediaproject.presentation.screen.admin.bag.AdminBagScreen
import com.mediaproject.presentation.screen.admin.home.AdminHomeScreen
import com.mediaproject.presentation.screen.admin.home.menu.AdminHomeMenuScreen
import com.mediaproject.presentation.screen.admin.marker.rent.RentMarkerScreen
import com.mediaproject.presentation.screen.admin.marker.returned.ReturnedMarkerScreen
import com.mediaproject.presentation.screen.admin.notice.AdminNoticeScreen
import com.mediaproject.presentation.screen.landing.LandingActivity
import com.mediaproject.presentation.screen.vm.AdminMapViewModel

@Composable
fun AdminHomeNavGraph(
    navController: NavHostController,
    context: Context,
    adminMapViewModel: AdminMapViewModel = hiltViewModel(),
    onClickQrScan: () -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = AdminHomeScreenRoute.Home.route
    ) {
        composable(route = AdminHomeScreenRoute.Home.route) {
            AdminHomeScreen(
                mapViewModel = adminMapViewModel,
                onClickQrScan = onClickQrScan
            ) {
                navController.navigate(AdminHomeScreenRoute.HomeMenu.route)
            }
        }
        composable(route = AdminHomeScreenRoute.HomeMenu.route) {
            AdminHomeMenuScreen(
                modifier = Modifier.background(color = Color.White),
                onClickNotice = {
                    navController.navigate(AdminHomeScreenRoute.Notice.route)
                },
                onClickBag = {
                    navController.navigate(AdminHomeScreenRoute.Bag.route)
                },
                onClickRentMarker = {
                    navController.navigate(AdminHomeScreenRoute.RentMarker.route)
                },
                onClickReturnedMarker = {
                    navController.navigate(AdminHomeScreenRoute.ReturnedMarker.route)
                },
                onSignOut = {
                    context.startActivity(
                        Intent(context, LandingActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                },
            ) {
                navController.popBackStack()
            }
        }
        composable(route = AdminHomeScreenRoute.RentMarker.route) {
            RentMarkerScreen {
                navController.popBackStack()
            }
        }
        composable(route = AdminHomeScreenRoute.ReturnedMarker.route) {
            ReturnedMarkerScreen {
                navController.popBackStack()
            }
        }
        composable(route = AdminHomeScreenRoute.Notice.route) {
            AdminNoticeScreen {
                navController.popBackStack()
            }
        }
        composable(route = AdminHomeScreenRoute.Bag.route) {
            AdminBagScreen {
                navController.popBackStack()
            }
        }
    }
}