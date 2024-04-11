package codeisgroup.sananismayilov.onboarding.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class WelcomeViewModel @Inject constructor(val speditor: SharedPreferences.Editor) : ViewModel() {


    fun putCompletedOnBoardShowing(completed: Boolean) {
        speditor.putBoolean("completedshowingonboarding", completed).apply()

    }


}