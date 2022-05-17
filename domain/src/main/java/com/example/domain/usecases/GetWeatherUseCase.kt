package com.example.domain.usecases

import com.example.common.utils.network.NetworkStatus
import com.example.domain.entities.WeatherResponse
import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(
        cityName: String,
        numberOfForecastDays: Int,
        appId: String,
        units: String
    ): NetworkStatus<WeatherResponse> = weatherRepository.getWeather(cityName, numberOfForecastDays, appId, units)

}
