package com.mediaproject.presentation.common.route

sealed class LandingScreenRoute(val route: String) {
    object Landing : LandingScreenRoute("landing_screen")
    object SignIn : LandingScreenRoute("sign_in_screen")
    object SignUp : LandingScreenRoute("sign_up_screen")
}