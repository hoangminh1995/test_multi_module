package com.example.mikecleanarchitecture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherService: WeatherService
) : ViewModel() {

    fun getWeather() {
        launchApi {
            weatherService.getWeather("ho chi minh")
        }
    }
}

fun ViewModel.launchApi(
    coroutineScope: CoroutineScope = viewModelScope,
    action: suspend () -> Unit
) {
    viewModelScope.launch {
        try {
            action.invoke()
        } catch (e: Exception) {
            Log.e("minh", "${e.message}")
        }
    }
}
