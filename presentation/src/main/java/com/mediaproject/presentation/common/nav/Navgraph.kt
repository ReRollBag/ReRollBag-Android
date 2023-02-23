package com.mediaproject.presentation.common.nav

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.presentation.common.route.Screen
import com.mediaproject.presentation.screen.landing.LandingScreen
import com.mediaproject.presentation.common.theme.AnimatedSplashScreenTheme
import com.mediaproject.presentation.screen.home.HomeActivity
import com.mediaproject.presentation.screen.landing.signin.SignInScreen
import com.mediaproject.presentation.screen.landing.signup.SignUpScreen

@Composable
fun LandingNavGraph(
    navController: NavHostController,
    context: Context,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Landing.route
    ) {
        composable(route = Screen.Landing.route) {
            AnimatedSplashScreenTheme {
                LandingScreen {
                    navController.navigate(Screen.SignIn.route) {
                        popUpTo(0)
                    }
                }
            }
        }
        composable(route = Screen.SignIn.route) {
            SignInScreen(
                onSuccessSignIn = {
                    context.startActivity(
                        Intent(context, HomeActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }
                    )
                },
                onSignUpBtnClick = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                onBackPress = {
                    navController.popBackStack()
                }
            )
        }
    }
}