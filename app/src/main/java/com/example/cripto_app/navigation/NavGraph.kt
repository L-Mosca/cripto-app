package com.example.cripto_app.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cripto_app.common.Constants
import com.example.cripto_app.presentation.details.DetailScreen
import com.example.cripto_app.presentation.list.ListScreen
import com.example.cripto_app.presentation.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(
            route = Screen.List.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }) {
            ListScreen(navController = navController)
        }

        composable(
            route = "${Screen.Detail.route}/{${Constants.COIN_DETAIL_SCREEN_ARGUMENT}}",
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
            arguments = listOf(navArgument(Constants.COIN_DETAIL_SCREEN_ARGUMENT) {
                type = NavType.StringType
            })
        ) {
            DetailScreen(navController = navController)
        }
    }
}