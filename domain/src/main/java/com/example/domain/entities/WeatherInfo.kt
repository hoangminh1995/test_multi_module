package com.example.domain.entities

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("dt")
    val date: Long,

    @SerializedName("temp")
    val temp: Temp,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("weather")
    val weather: List<WeatherDescription>
)
