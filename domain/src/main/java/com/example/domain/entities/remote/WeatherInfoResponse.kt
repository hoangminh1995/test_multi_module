package com.example.domain.entities.remote

import com.google.gson.annotations.SerializedName

data class WeatherInfoResponse(
    @SerializedName("dt")
    val date: Long,

    @SerializedName("temp")
    val temp: TempResponse,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("weather")
    val weather: List<WeatherDescriptionResponse>
)
