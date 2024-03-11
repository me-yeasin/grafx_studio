package com.grafxstudio.grafx_studio.root_view_models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel(){
    private val isDarkMode : MutableState<Boolean> = mutableStateOf(false)
    fun getIsDarkMode () = isDarkMode.value
    fun toggleTheme() {
        isDarkMode.value = !isDarkMode.value
    }
}