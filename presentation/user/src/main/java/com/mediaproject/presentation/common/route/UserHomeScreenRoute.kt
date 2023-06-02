package com.mediaproject.presentation.common.route

sealed class UserHomeScreenRoute(val route: String) {
    object Home : UserHomeScreenRoute(route = "home_screen")
    object HomeMenu : UserHomeScreenRoute(route = "home_menu")
    object CheckAdmin : UserHomeScreenRoute("check_admin")
    object RentList : UserHomeScreenRoute(route = "rent_list")
    object Notice : UserHomeScreenRoute(route = "notice")
}
