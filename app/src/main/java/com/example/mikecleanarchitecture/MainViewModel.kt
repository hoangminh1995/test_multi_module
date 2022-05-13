package com.example.mikecleanarchitecture

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherService: WeatherService
) : ViewModel() {

    suspend fun getWeather() {
        try {
            weatherService.getWeather("ho chi minh")
        } catch (e: Exception) {
            Log.e("minh", "${e.message}")
        }
    }
}
