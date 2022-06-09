package com.example.domain.entities.remote

import com.google.gson.annotations.SerializedName

data class WeatherDescriptionResponse(
    @SerializedName("description")
    val description: String
)
