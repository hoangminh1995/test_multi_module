package com.example.mikecleanarchitecture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.network.NetworkStatus
import com.example.data.remote.api.APP_ID_DEFAULT
import com.example.data.remote.api.NUMBER_OF_FORECAST_DEFAULT
import com.example.data.remote.api.UNIT_DEFAULT
import com.example.domain.usecases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    fun getWeather() {
        viewModelScope.launch {
            getWeatherUseCase.invoke(
                "ho chi minh",
                NUMBER_OF_FORECAST_DEFAULT,
                APP_ID_DEFAULT,
                UNIT_DEFAULT
            ).collect {
                Log.e("minh","data $it")
                when (it) {
                    is NetworkStatus.Success -> Log.e("minh", "success ${it.data}")
                    is NetworkStatus.Error -> Log.e("minh", "error ${it.errorMessage}")
                    is NetworkStatus.Loading -> Unit
                }
            }
        }
    }
}
