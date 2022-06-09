package com.example.domain.entities.remote

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list")
    val list: List<WeatherInfoResponse>
)
