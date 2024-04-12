package codeisgroup.sananismayilov.bottomnav

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import codeisgroup.sananismayilov.bottomnav.navigation.NavGraph
import codeisgroup.sananismayilov.bottomnav.navigation.util.NavBarItem
import codeisgroup.sananismayilov.bottomnav.ui.theme.BottomNavTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavTheme {
                val items = listOf(
                    NavBarItem(
                        "home",
                        icon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    NavBarItem(
                        "notifications",
                        20,
                        Icons.Filled.Notifications,
                        unselectedIcon = Icons.Outlined.Notifications
                    ),
                    NavBarItem(
                        "settings",
                        icon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings
                    )
                )

                val navController = rememberNavController()

                var selectedindex by rememberSaveable {
                    mutableStateOf(0)
                }

                Scaffold(bottomBar = {
                    NavigationBar(containerColor = Color.White) {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedindex == index,
                                onClick = {
                                    navController.navigate(item.name)
                                    selectedindex = index
                                },
                                icon = {
                                    BadgedBox(badge = {
                                        item.badgeCount?.let {
                                            Badge {
                                                Text(text = item.badgeCount.toString())
                                            }
                                        }
                                    }) {
                                        Icon(
                                            imageVector = if (index == selectedindex) {
                                                item.icon
                                            } else
                                                item.unselectedIcon,
                                            contentDescription = item.name
                                        )
                                    }
                                }, colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.Yellow
                                )
                            )
                        }
                    }

                }) {
                    NavGraph(navController = navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomNavTheme {

    }
}