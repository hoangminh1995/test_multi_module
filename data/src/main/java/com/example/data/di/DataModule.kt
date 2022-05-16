package com.example.data.di

import com.example.data.coroutines.DefaultDispatcherProvider
import com.example.data.coroutines.DispatcherProvider
import com.example.data.local.WeatherLocalDataSource
import com.example.data.local.WeatherLocalDataSourceImpl
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
    internal fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()

    /// Provide Data Sources ///

    @Provides
    fun provideWeatherRemoteDataSource(weatherService: WeatherService): WeatherRemoteDataSource {
        return WeatherRemoteDataSourceImpl(weatherService)
    }

    @Provides
    fun provideWeatherLocalDataSource(): WeatherLocalDataSource {
        return WeatherLocalDataSourceImpl()
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
