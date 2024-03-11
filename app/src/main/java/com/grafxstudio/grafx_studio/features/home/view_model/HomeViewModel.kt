package com.grafxstudio.grafx_studio.features.home.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grafxstudio.grafx_studio.network.GrafxRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val grafxRepo: GrafxRepo) : ViewModel() {
    init {
        viewModelScope.launch {
            val result = grafxRepo.getAllLogos()
            Log.d("my_result", "firebase: $result")
        }
    }
}