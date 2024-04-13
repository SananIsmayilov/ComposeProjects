package codeisgroup.sananismayilov.navigationdrawer.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val tittle: String,
    val selectedIcon: ImageVector,
    val unSelectableIcon: ImageVector,
    val badge: Int? = null

)
