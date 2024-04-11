package codeisgroup.sananismayilov.onboarding.navigation

sealed class Screen(val route : String) {
    object Welcome : Screen("welcomescreen")
    object Home : Screen("homescreen")
}