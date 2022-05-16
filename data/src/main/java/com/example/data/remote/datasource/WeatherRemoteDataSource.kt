package com.example.data.remote.datasource

import com.example.common.utils.network.NetworkStatus
import com.example.domain.entities.WeatherInfoResponse

interface WeatherRemoteDataSource {
    suspend fun getWeather(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherInfoResponse>
}
