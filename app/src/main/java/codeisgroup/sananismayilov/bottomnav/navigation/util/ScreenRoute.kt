package codeisgroup.sananismayilov.bottomnav.navigation.util

sealed class ScreenRoute
    (val route: String) {
    object Home : ScreenRoute("home")
    object Settings : ScreenRoute("settings")
    object Notification : ScreenRoute("notifications")
}