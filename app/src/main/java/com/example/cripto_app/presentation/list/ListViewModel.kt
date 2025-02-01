package com.example.cripto_app.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.cripto_app.base.BaseViewModel
import com.example.cripto_app.common.Resource
import com.example.cripto_app.domain.models.CoinGeneralData
import com.example.cripto_app.domain.use_case.GetCryptoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val cryptoListUseCase: GetCryptoListUseCase) :
    BaseViewModel() {

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _coinList = mutableStateOf<List<CoinGeneralData>>(emptyList())
    val coinList: State<List<CoinGeneralData>> = _coinList

    init {
        fetchCoinList()
    }

    private fun fetchCoinList() {
        cryptoListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let { _coinList.value = it }
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