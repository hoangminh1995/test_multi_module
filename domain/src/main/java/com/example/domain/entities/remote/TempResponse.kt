package com.example.domain.entities.remote

import com.google.gson.annotations.SerializedName

data class TempResponse(
    @SerializedName("min")
    val min: Double,
    @SerializedName("max")
    val max: Double
)
