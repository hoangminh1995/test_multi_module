package com.example.data.repository

import com.example.common.utils.network.NetworkStatus
import com.example.data.coroutines.DispatcherProvider
import com.example.data.local.WeatherLocalDataSource
import com.example.data.remote.datasource.WeatherRemoteDataSource
import com.example.domain.entities.WeatherInfoResponse
import com.example.domain.repository.WeatherRepository
import com.google.gson.JsonElement
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val dispatcherProvider: DispatcherProvider
) : WeatherRepository {

    override suspend fun getWeather(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherInfoResponse> {
        return withContext(dispatcherProvider.io()) {
            weatherRemoteDataSource.getWeather(cityName, numberOfForecastDays, appId, units)
        }
    }
}