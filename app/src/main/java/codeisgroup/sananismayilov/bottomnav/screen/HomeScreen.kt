package codeisgroup.sananismayilov.bottomnav.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)) {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun pr() {
    HomeScreen()
}