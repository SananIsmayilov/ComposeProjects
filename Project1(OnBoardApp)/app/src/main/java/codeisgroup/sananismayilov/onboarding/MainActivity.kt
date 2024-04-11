package codeisgroup.sananismayilov.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import codeisgroup.sananismayilov.onboarding.navigation.NavGraph
import codeisgroup.sananismayilov.onboarding.navigation.Screen
import codeisgroup.sananismayilov.onboarding.ui.theme.OnBoardingTheme
import codeisgroup.sananismayilov.onboarding.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OnBoardingTheme {
                val vm: MainViewModel = viewModel()
                vm.getCompleteState()
                val screen = vm._startDestination.value
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    println("-----s${screen}")
                    val navcontroller = rememberNavController()
                    NavGraph(
                        navController = navcontroller,
                        startdestnation = screen
                    )
                }
            }
        }

    }
}


