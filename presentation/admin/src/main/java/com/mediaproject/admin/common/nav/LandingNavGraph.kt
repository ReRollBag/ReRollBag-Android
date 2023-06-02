package com.mediaproject.admin.common.nav

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mediaproject.admin.common.route.LandingScreenRoute
import com.mediaproject.admin.common.theme.AnimatedSplashScreenTheme
import com.mediaproject.admin.screen.access.AccessActivity
import com.mediaproject.admin.screen.home.HomeActivity
import com.mediaproject.admin.screen.landing.LandingScreen
import com.mediaproject.admin.screen.landing.signin.SignInScreen
import com.mediaproject.admin.screen.landing.signup.SignUpScreen
import com.mediaproject.admin.screen.vm.SignInViewModel

@Composable
fun LandingNavGraph(
    navController: NavHostController,
    context: Context,
    viewModel: SignInViewModel,
    googleSignIn: () -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = LandingScreenRoute.Landing.route
    ) {
        composable(route = LandingScreenRoute.Landing.route) {
            AnimatedSplashScreenTheme {
                LandingScreen(
                    viewModel = viewModel,
                    onTimeoutHome = {
                        context.startActivity(
                            Intent(context, HomeActivity::class.java).apply {
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            }
                        )
                    },
                    onTimeoutSignIn = {
                        navController.navigate(LandingScreenRoute.SignIn.route) {
                            popUpTo(0)
                        }
                    }
                )
            }
        }
        composable(route = LandingScreenRoute.SignIn.route) {
            SignInScreen(
                viewModel = viewModel,
                onSuccessSignIn = {
                    context.startActivity(
                        Intent(context, HomeActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                },
                onSignUpBtnClick = {
                    navController.navigate(LandingScreenRoute.SignUp.route)
                },
                onGoogleSignIn = googleSignIn,
                onSocialSignUp = {
                    navController.navigate(LandingScreenRoute.SocialSignUp.route)
                }
            )
        }
        composable(route = LandingScreenRoute.SignUp.route) {
            SignUpScreen(
                onBackPress = {
                    navController.popBackStack()
                },
                onSuccessSignUp = {
                    context.startActivity(
                        Intent(context, AccessActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                }
            )
        }
        composable(route = LandingScreenRoute.SocialSignUp.route) {
            SignUpScreen(
                isSocial = true,
                onBackPress = {
                    navController.popBackStack()
                },
                onSuccessSignUp = {
                    context.startActivity(
                        Intent(context, AccessActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                }
            )
        }
    }
}