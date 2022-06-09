package com.example.domain.entities.mapper

import com.example.domain.entities.remote.WeatherInfoResponse
import com.example.domain.entities.local.WeatherEntity

fun WeatherInfoResponse.map() =
    WeatherEntity(this.date, this.pressure, this.humidity, this.temp, this.weather)
