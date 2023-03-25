package com.mediaproject.presentation.common.route

sealed class HomeScreenRoute(val route: String) {
    object Home : HomeScreenRoute(route = "home_screen")
    object HomeMenu : HomeScreenRoute(route = "home_menu")
    object RentList : HomeScreenRoute(route = "rent_list")
    object Notice : HomeScreenRoute(route = "notice")
}
