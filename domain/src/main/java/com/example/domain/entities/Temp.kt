package com.example.domain.entities

import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("min")
    val min: Double,
    @SerializedName("max")
    val max: Double
) {
    fun getAverage() = ((min + max) / 2).toInt()
}
