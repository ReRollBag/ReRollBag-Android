package com.mediaproject.admin.common.route

sealed class LandingScreenRoute(val route: String) {
    object Landing : LandingScreenRoute("landing_screen")
    object SignIn : LandingScreenRoute("sign_in_screen")
    object SignUp : LandingScreenRoute("sign_up_screen")
    object SocialSignUp : LandingScreenRoute("social_sign_up_screen")
}