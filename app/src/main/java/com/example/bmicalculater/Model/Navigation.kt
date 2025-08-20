package com.example.bmicalculater.Model

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object First : Screen("first")
    object Second : Screen("second")
}