package com.example.cripto_app.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object List : Screen("list")
    object Detail : Screen("detail")
}