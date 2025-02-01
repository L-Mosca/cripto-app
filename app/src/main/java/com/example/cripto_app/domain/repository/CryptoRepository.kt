package com.example.cripto_app.domain.repository

import com.example.cripto_app.domain.models.CoinGeneralData

interface CryptoRepository {
    suspend fun fetchCryptoList() : List<CoinGeneralData>?
}