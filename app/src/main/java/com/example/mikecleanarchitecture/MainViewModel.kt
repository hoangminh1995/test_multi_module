package com.example.mikecleanarchitecture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.network.NetworkStatus
import com.example.data.remote.api.APP_ID_DEFAULT
import com.example.data.remote.api.NUMBER_OF_FORECAST_DEFAULT
import com.example.data.remote.api.UNIT_DEFAULT
import com.example.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    fun getWeather() {
        launchApi {
            weatherRepository.getWeather(
                "ho chi minh",
                NUMBER_OF_FORECAST_DEFAULT,
                APP_ID_DEFAULT,
                UNIT_DEFAULT
            )
        }
    }
}

inline fun <reified T> ViewModel.launchApi(
    coroutineScope: CoroutineScope = viewModelScope,
    crossinline action: suspend () -> NetworkStatus<T>
): Job {
    return coroutineScope.launch {
        try {
            action.invoke()
        } catch (e: Exception) {
            Log.e("minh", "${e.message}")
        }
    }
}
