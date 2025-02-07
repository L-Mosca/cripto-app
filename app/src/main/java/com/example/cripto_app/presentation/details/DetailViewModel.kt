package com.example.cripto_app.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.cripto_app.base.BaseViewModel
import com.example.cripto_app.common.Constants
import com.example.cripto_app.common.Resource
import com.example.cripto_app.domain.models.CoinDetails
import com.example.cripto_app.domain.use_case.GetCryptoDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCryptoDetails: GetCryptoDetails
) : BaseViewModel() {

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _coinDetails = mutableStateOf<CoinDetails?>(null)
    val coinDetails: State<CoinDetails?> = _coinDetails

    init {
        savedStateHandle.get<String>(Constants.COIN_DETAIL_SCREEN_ARGUMENT)
            ?.let { fetchCoinDetails(it) }
    }

    private fun fetchCoinDetails(index: String) {
        getCryptoDetails(index).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    result.data?.let { _coinDetails.value = it }
                    _isLoading.value = false
                }
                is Resource.Loading -> {
                    _isLoading.value = true
                }
                is Resource.Error -> {
                    _isLoading.value = false
                }
            }
        }.launchIn(viewModelScope)
    }
}