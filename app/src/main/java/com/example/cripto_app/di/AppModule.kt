package com.example.cripto_app.di

import com.example.cripto_app.BuildConfig
import com.example.cripto_app.data.remote.CryptoApi
import com.example.cripto_app.data.repository.CryptoRepositoryImpl
import com.example.cripto_app.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = CryptoApi.newInstance(BuildConfig.BASE_URL)

    @Provides
    @Singleton
    fun provideCryptoApi(client: HttpClient): CryptoApi = CryptoApi(client)

    @Provides
    @Singleton
    fun provideCryptoRepository(cryptoApi: CryptoApi): CryptoRepository {
        return CryptoRepositoryImpl(cryptoApi)
    }
}