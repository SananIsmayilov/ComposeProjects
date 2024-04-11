package codeisgroup.sananismayilov.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import codeisgroup.sananismayilov.onboarding.screen.HomeScreen
import codeisgroup.sananismayilov.onboarding.screen.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController, startdestnation: String) {
    NavHost(navController = navController, startDestination = startdestnation) {
        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

    }


}