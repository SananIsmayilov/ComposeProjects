package codeisgroup.sananismayilov.onboarding.viewmodel

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import codeisgroup.sananismayilov.onboarding.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val sp: SharedPreferences) : ViewModel() {

    var _startDestination = mutableStateOf<String>(Screen.Welcome.route)
    val startDestination: State<String> = _startDestination

    init {
        getCompleteState()
    }

    fun getCompleteState() {
        val completedState = sp.getBoolean("completedshowingonboarding", false)
        if (completedState) {
            _startDestination.value = Screen.Home.route
        } else {
            _startDestination.value = Screen.Welcome.route
        }


    }
}