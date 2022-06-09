package com.example.data.local.datasource

import com.example.domain.entities.local.WeatherEntity


interface WeatherLocalDataSource {
    suspend fun getWeather(): List<WeatherEntity>
    suspend fun saveWeather(list: List<WeatherEntity>)
}
