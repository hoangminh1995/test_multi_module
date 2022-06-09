package com.example.data.local.database

import androidx.room.TypeConverter
import com.example.domain.entities.remote.TempResponse
import com.example.domain.entities.remote.WeatherDescriptionResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromTemp(item: TempResponse): String {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun toTemp(item: String): TempResponse {
        return Gson().fromJson(item, object : TypeToken<TempResponse>() {}.type)
    }

    @TypeConverter
    fun fromWeatherDescriptionList(item: List<WeatherDescriptionResponse>): String {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun toWeatherDescriptionList(item: String): List<WeatherDescriptionResponse> {
        return Gson().fromJson(item, object : TypeToken<List<WeatherDescriptionResponse>>() {}.type)
    }
}
