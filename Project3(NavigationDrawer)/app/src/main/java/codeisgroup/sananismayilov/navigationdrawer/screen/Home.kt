package codeisgroup.sananismayilov.navigationdrawer.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
}

@Preview
@Composable
fun prew() {
    Settings()
}