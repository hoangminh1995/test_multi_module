package com.example.mikecleanarchitecture.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.common.base.BaseActivity
import com.example.common.utils.network.NetworkStatus
import com.example.mikecleanarchitecture.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getWeather("Ho Chi Minh")
            .flowWithLifecycle(lifecycle)
            .onEach {
                when (it) {
                    is NetworkStatus.Loading -> Log.e("minh", "show loading")
                    is NetworkStatus.Success -> {
                        Log.e("minh", "hide loading")
                        Log.e("minh", "${it.data}")
                    }
                    is NetworkStatus.Error -> {
                        Log.e("minh", "hide loading")
                        Log.e("minh", "${it.errorMessage}")
                    }
                }
            }
            .launchIn(lifecycleScope)
    }
}
