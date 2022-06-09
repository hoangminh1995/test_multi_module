package com.example.domain.entities.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.remote.TempResponse
import com.example.domain.entities.remote.WeatherDescriptionResponse

@Entity(tableName = "weather")
data class WeatherEntity(
    @ColumnInfo(name = "date")
    val date: Long,

    @ColumnInfo(name = "pressure")
    val pressure: Int,

    @ColumnInfo(name = "humidity")
    val humidity: Int,

    @ColumnInfo(name = "temp")
    val temp: TempResponse,

    @ColumnInfo(name = "weather")
    val weather: List<WeatherDescriptionResponse>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
