package com.example.cripto_app.data.repository

import com.example.cripto_app.data.remote.CryptoApi
import com.example.cripto_app.domain.models.CoinDetails
import com.example.cripto_app.domain.models.CoinGeneralData
import com.example.cripto_app.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val cryptoApi: CryptoApi) :
    CryptoRepository {

    override suspend fun fetchCryptoList() : List<CoinGeneralData>? {
        return cryptoApi.fetchCoinList()
    }

    override suspend fun fetchCryptoDetails(index: String): CoinDetails? {
        return cryptoApi.fetchCoinDetails(index)
    }
}