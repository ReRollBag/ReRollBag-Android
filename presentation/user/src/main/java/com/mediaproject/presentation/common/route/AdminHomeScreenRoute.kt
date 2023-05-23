package com.mediaproject.presentation.common.route

sealed class AdminHomeScreenRoute(val route: String) {
    object Home : AdminHomeScreenRoute(route = "home_screen")
    object HomeMenu : AdminHomeScreenRoute(route = "home_menu")
}
