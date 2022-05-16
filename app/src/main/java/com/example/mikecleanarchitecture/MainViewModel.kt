package com.example.mikecleanarchitecture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mikecleanarchitecture.response.DomainError
import com.example.mikecleanarchitecture.response.Either
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherService: WeatherService
) : ViewModel() {

    fun getWeather() {
        launchApi {
            Either.Value(weatherService.getWeather("ho chi minh"))
        }
    }
}

inline fun <reified T> ViewModel.launchApi(
    coroutineScope: CoroutineScope = viewModelScope,
    crossinline action: suspend () -> Either<T, DomainError>
): Job {
    return coroutineScope.launch {
        try {
            action.invoke()
        } catch (e: Exception) {
            Log.e("minh", "${e.message}")
        }
    }
}
