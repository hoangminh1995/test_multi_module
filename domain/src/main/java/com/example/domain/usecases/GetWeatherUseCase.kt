package com.example.domain.usecases

import com.example.common.utils.network.NetworkStatus
import com.example.domain.entities.WeatherInfoResponse
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherInfoResponse> = weatherRepository.getWeather(cityName, numberOfForecastDays, appId, units)

}
