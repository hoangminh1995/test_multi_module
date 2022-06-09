package com.example.data.di

import com.example.data.utils.coroutines.DispatcherProviderImpl
import com.example.data.utils.coroutines.DispatcherProvider
import com.example.data.local.datasource.WeatherLocalDataSource
import com.example.data.local.datasource.WeatherLocalDataSourceImpl
import com.example.data.local.database.WeatherDao
import com.example.data.remote.api.WeatherService
import com.example.data.remote.datasource.WeatherRemoteDataSource
import com.example.data.remote.datasource.WeatherRemoteDataSourceImpl
import com.example.data.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    /// Provide DispatcherProvider ///

    @Provides
    @Singleton
    internal fun provideDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl()

    /// Provide Data Sources ///

    @Provides
    fun provideWeatherRemoteDataSource(weatherService: WeatherService): WeatherRemoteDataSource {
        return WeatherRemoteDataSourceImpl(weatherService)
    }

    @Provides
    fun provideWeatherLocalDataSource(weatherDao: WeatherDao): WeatherLocalDataSource {
        return WeatherLocalDataSourceImpl(weatherDao)
    }

    /// Provide repositories ///

    @Singleton
    @Provides
    fun provideWeatherRepository(
        dispatcherProvider: DispatcherProvider,
        weatherRemoteDataSource: WeatherRemoteDataSource,
        weatherLocalDataSource: WeatherLocalDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            weatherRemoteDataSource,
            weatherLocalDataSource,
            dispatcherProvider
        )
    }

}
