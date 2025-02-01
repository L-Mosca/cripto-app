package com.example.cripto_app.data.remote

import android.util.Log
import com.example.cripto_app.common.Constants
import com.example.cripto_app.domain.models.CoinDetails
import com.example.cripto_app.domain.models.CoinGeneralData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class CryptoApi(private val client: HttpClient) {

    companion object {
        fun newInstance(url: String): HttpClient {
            return HttpClient(Android) {
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.d("HTTP call", message)
                        }
                    }
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
                defaultRequest { url(url) }

            }
        }
    }

    suspend fun fetchCoinList(): List<CoinGeneralData>? {
        return client.get(Constants.FETCH_COIN_LIST).body<List<CoinGeneralData>?>()
    }

    suspend fun fetchCoinDetails(index: String): CoinDetails? {
        return client.get("${Constants.FETCH_COIN_DETAILS}/$index").body<CoinDetails?>()
    }
}
