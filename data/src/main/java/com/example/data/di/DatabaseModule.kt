package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.database.WeatherDao
import com.example.data.local.database.WeatherDatabase
import com.example.data.local.database.WeatherDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDatabase =
        Room.databaseBuilder(
            context, WeatherDatabase::class.java, DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDatabase: WeatherDatabase):
            WeatherDao = weatherDatabase.weatherDao()
}
