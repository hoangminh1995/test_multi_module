package com.example.data.local


interface WeatherLocalDataSource {
    suspend fun getWeather()
}
