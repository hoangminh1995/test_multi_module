package com.example.data.remote.datasource

import com.example.common.utils.network.NetworkStatus
import com.example.domain.entities.WeatherInfo
import com.example.domain.entities.WeatherResponse

interface WeatherRemoteDataSource {
    suspend fun getWeather(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherResponse>
}
