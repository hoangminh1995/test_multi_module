package com.example.mikecleanarchitecture

import com.google.gson.JsonElement
import retrofit2.http.GET
import retrofit2.http.Query

const val APP_ID_DEFAULT = "60c6fbeb4b93ac653c492ba806fc346d"
const val UNIT_DEFAULT = "Metric"
const val NUMBER_OF_FORECAST_DEFAULT = 7

interface WeatherService {

    @GET("forecast/daily")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("cnt") numberOfForecastDays: Int = NUMBER_OF_FORECAST_DEFAULT,
        @Query("appid") appId: String = APP_ID_DEFAULT,
        @Query("units") units: String = UNIT_DEFAULT
    ): JsonElement
}
