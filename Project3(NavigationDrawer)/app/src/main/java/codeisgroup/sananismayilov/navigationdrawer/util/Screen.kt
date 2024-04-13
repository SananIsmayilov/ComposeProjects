package codeisgroup.sananismayilov.navigationdrawer.util

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Settings : Screen("Settings")


}