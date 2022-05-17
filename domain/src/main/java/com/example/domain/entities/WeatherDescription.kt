package com.example.domain.entities

import com.google.gson.annotations.SerializedName

data class WeatherDescription(
    @SerializedName("description")
    val description: String
)
