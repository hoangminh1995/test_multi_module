package com.example.mikecleanarchitecture.activity

import androidx.lifecycle.ViewModel
import com.example.common.utils.network.NetworkStatus
import com.example.data.remote.api.APP_ID_DEFAULT
import com.example.data.remote.api.NUMBER_OF_FORECAST_DEFAULT
import com.example.data.remote.api.UNIT_DEFAULT
import com.example.domain.usecases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    fun getWeather(cityName: String) = flow {
        emit(NetworkStatus.Loading())
        when (val result = getWeatherUseCase.invoke(
            cityName, NUMBER_OF_FORECAST_DEFAULT,
            APP_ID_DEFAULT, UNIT_DEFAULT
        )) {
            is NetworkStatus.Success -> emit(NetworkStatus.Success(result.data))
            is NetworkStatus.Error -> emit(NetworkStatus.Error(result.errorMessage, null))
            else -> Unit
        }
    }
}
