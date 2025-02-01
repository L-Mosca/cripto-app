package com.example.cripto_app.domain.use_case

import com.example.cripto_app.common.Resource
import com.example.cripto_app.domain.models.CoinGeneralData
import com.example.cripto_app.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCryptoListUseCase @Inject constructor(private val repository: CryptoRepository) {

    operator fun invoke(): Flow<Resource<List<CoinGeneralData>?>> = flow {
        try {
            emit(Resource.Loading())
            val coinList = repository.fetchCryptoList()
            emit(Resource.Success(data = coinList))
        } catch (e: Exception) {
            emit(Resource.Error("An unexpected error occurred"))
        }
    }
}