package com.example.cripto_app.domain.use_case

import com.example.cripto_app.common.Resource
import com.example.cripto_app.domain.models.CoinDetails
import com.example.cripto_app.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCryptoDetails @Inject constructor(private val repository: CryptoRepository) {

    operator fun invoke(index: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetails = repository.fetchCryptoDetails(index)
            coinDetails?.let {
                emit(Resource.Success(data = it))
                return@flow
            }
            emit(Resource.Error("An unexpected error occurred"))
        } catch (e: Exception) {
            emit(Resource.Error("An unexpected error occurred"))
        }
    }
}