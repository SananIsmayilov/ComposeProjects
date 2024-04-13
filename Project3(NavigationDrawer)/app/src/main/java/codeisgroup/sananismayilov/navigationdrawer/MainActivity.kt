package codeisgroup.sananismayilov.navigationdrawer

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import codeisgroup.sananismayilov.navigationdrawer.navigation.NavigationGraph
import codeisgroup.sananismayilov.navigationdrawer.navigation.NavigationItem
import codeisgroup.sananismayilov.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val items = listOf(
                    NavigationItem("Home", Icons.Filled.Home, Icons.Outlined.Home, 1000),
                    NavigationItem("Settings", Icons.Filled.Settings, Icons.Outlined.Settings)
                )
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val navController = rememberNavController()
                var selectedItemIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet {
                                Spacer(modifier = Modifier.height(10.dp))
                                items.forEachIndexed { index, navigationItem ->
                                    NavigationDrawerItem(
                                        label = {
                                            Text(
                                                text = navigationItem.tittle,
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        },
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            scope.launch {
                                                drawerState.close()
                                            }
                                            navController.navigate(navigationItem.tittle)
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = if (selectedItemIndex == index) {
                                                    navigationItem.selectedIcon
                                                } else navigationItem.unSelectableIcon,
                                                contentDescription = null

                                            )
                                        },
                                        badge = {
                                            navigationItem.badge?.let {
                                                Text(
                                                    text = if (navigationItem.badge > 999) "${navigationItem.badge - 1}+" else navigationItem.badge.toString(),
                                                    color = Color.Red
                                                )
                                            }
                                        },
                                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                    )
                                }
                            }
                        },
                        drawerState = drawerState
                    ) {
                        Scaffold(topBar = {
                            TopAppBar(title = { Text(text = "App") }, navigationIcon = {
                                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "icons"
                                    )
                                }
                            })
                        }) {
                            NavigationGraph(navHostController = navController)

                            val context = LocalContext.current as Activity
                            BackHandler(true) {
                                if (drawerState.isOpen) {
                                    scope.launch { drawerState.close() }
                                } else {
                                    context.finish()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationDrawerTheme {
        NavigationGraph(navHostController = rememberNavController())
    }
}