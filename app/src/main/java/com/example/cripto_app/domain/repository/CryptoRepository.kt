package com.example.cripto_app.domain.repository

import com.example.cripto_app.domain.models.CoinDetails
import com.example.cripto_app.domain.models.CoinGeneralData

interface CryptoRepository {
    suspend fun fetchCryptoList() : List<CoinGeneralData>?
    suspend fun fetchCryptoDetails(index: String): CoinDetails?
}