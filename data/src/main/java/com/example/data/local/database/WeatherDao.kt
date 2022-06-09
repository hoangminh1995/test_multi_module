package com.example.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.entities.local.WeatherEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWeathers(weathers: List<WeatherEntity>): LongArray

    @Query("SELECT * FROM weather")
    suspend fun queryWeather(): List<WeatherEntity>
}
