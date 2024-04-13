package codeisgroup.sananismayilov.navigationdrawer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import codeisgroup.sananismayilov.navigationdrawer.screen.Home
import codeisgroup.sananismayilov.navigationdrawer.screen.Settings
import codeisgroup.sananismayilov.navigationdrawer.util.Screen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route){
            Home()
        }
        composable(route = Screen.Settings.route){
            Settings()
        }
    }

}