package codeisgroup.sananismayilov.bottomnav.navigation.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val name: String,
    val badgeCount: Int? = null,
    val icon: ImageVector,
    val unselectedIcon : ImageVector
)
