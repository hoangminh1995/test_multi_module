package com.example.data.repository

import com.example.common.utils.network.NetworkStatus
import com.example.data.utils.coroutines.DispatcherProvider
import com.example.data.local.WeatherLocalDataSource
import com.example.data.remote.datasource.WeatherRemoteDataSource
import com.example.domain.entities.WeatherResponse
import com.example.domain.repository.WeatherRepository
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
    ): NetworkStatus<WeatherResponse> {
        return withContext(dispatcherProvider.io()) {
            weatherRemoteDataSource.getWeather(cityName, numberOfForecastDays, appId, units)
        }
    }
}
