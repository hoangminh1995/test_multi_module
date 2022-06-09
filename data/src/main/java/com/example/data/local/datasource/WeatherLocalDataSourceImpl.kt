package com.example.data.local.datasource

import com.example.data.local.database.WeatherDao
import com.example.domain.entities.local.WeatherEntity
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor(private val weatherDao: WeatherDao) :
    WeatherLocalDataSource {
    override suspend fun getWeather(): List<WeatherEntity> {
        return weatherDao.queryWeather()
    }

    override suspend fun saveWeather(list: List<WeatherEntity>) {
        weatherDao.insertWeathers(list)
    }
}
