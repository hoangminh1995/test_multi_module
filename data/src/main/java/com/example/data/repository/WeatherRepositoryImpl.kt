package com.example.data.repository

import com.example.common.utils.network.NetworkStatus
import com.example.data.utils.coroutines.DispatcherProvider
import com.example.data.local.datasource.WeatherLocalDataSource
import com.example.data.remote.datasource.WeatherRemoteDataSource
import com.example.domain.entities.remote.WeatherResponse
import com.example.domain.entities.mapper.map
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
        }.also {response->
            val result = response.data?.list?.map { weatherInfo ->
                weatherInfo.map()
            }
            result?.let { it1 -> weatherLocalDataSource.saveWeather(it1) }
        }
    }
}
