package codeisgroup.sananismayilov.bottomnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import codeisgroup.sananismayilov.bottomnav.navigation.util.ScreenRoute
import codeisgroup.sananismayilov.bottomnav.screen.HomeScreen
import codeisgroup.sananismayilov.bottomnav.screen.NotificationScreen
import codeisgroup.sananismayilov.bottomnav.screen.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenRoute.Home.route) {
        composable(ScreenRoute.Home.route) {
            HomeScreen()
        }
        composable(ScreenRoute.Settings.route) {
            SettingsScreen()
        }
        composable(ScreenRoute.Notification.route) {
            NotificationScreen()
        }
    }

}