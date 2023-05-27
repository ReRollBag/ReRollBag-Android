package com.mediaproject.presentation.common.route

sealed class AdminHomeScreenRoute(val route: String) {
    object Home : AdminHomeScreenRoute(route = "admin_home_screen")
    object HomeMenu : AdminHomeScreenRoute(route = "admin_home_menu")
    object RentMarker : AdminHomeScreenRoute(route = "admin_rent_marker")
    object ReturnedMarker : AdminHomeScreenRoute(route = "admin_returned_marker")
    object Notice : AdminHomeScreenRoute(route = "admin_notice")
    object Bag : AdminHomeScreenRoute(route = "admin_bag")

}
