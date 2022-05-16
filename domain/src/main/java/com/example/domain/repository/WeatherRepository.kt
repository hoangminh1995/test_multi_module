package com.example.domain.repository

import com.example.common.utils.network.NetworkStatus
import com.example.domain.entities.WeatherInfoResponse

interface WeatherRepository {
    suspend fun getWeather(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherInfoResponse>
}
