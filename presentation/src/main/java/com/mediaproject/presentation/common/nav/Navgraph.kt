package com.mediaproject.presentation.common.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.presentation.common.screen.route.Screen
import com.mediaproject.presentation.common.screen.LandingScreen
import com.mediaproject.presentation.common.theme.AnimatedSplashScreenTheme
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import com.mediaproject.presentation.screen.home.HomeScreen
import com.mediaproject.presentation.screen.signin.SignInScreen
import com.mediaproject.presentation.screen.signup.SignUpScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
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
                    navController.navigate(Screen.Home.route)
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
        composable(route = Screen.Home.route) {
            ReRollBagTheme {
                HomeScreen()
            }
        }
    }
}