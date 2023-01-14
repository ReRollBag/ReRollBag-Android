package com.mediaproject.presentation.common.route

sealed class Screen(val route: String) {
    object Landing : Screen("landing_screen")
    object SignIn : Screen("sign_in_screen")
    object SignUp : Screen("sign_up_screen")
}