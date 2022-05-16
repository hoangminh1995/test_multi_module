package com.example.data.remote.datasource

import com.example.common.utils.network.NetworkStatus
import com.example.data.remote.api.WeatherService
import com.example.data.safeApiCall
import com.example.domain.entities.WeatherInfoResponse

class WeatherRemoteDataSourceImpl(private val weatherService: WeatherService) : WeatherRemoteDataSource {

    override suspend fun getWeather(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherInfoResponse> {
        return safeApiCall {
            weatherService.getWeather(cityName, numberOfForecastDays, appId, units)
        }
    }
}
