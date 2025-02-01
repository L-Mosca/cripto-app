package com.example.cripto_app.presentation.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.example.cripto_app.base.BaseViewModel
import com.example.cripto_app.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : BaseViewModel() {

    init {
        savedStateHandle.get<String>(Constants.COIN_DETAIL_SCREEN_ARGUMENT)
            ?.let { coinIndex ->
                Log.e("test", "CoinIndex: $coinIndex")
            }
    }
}