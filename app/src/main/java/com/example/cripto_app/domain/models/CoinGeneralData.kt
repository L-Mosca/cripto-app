package com.example.cripto_app.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeneralData(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("symbol") val symbol: String?,
    @SerialName("rank") val rank: Int?,
    @SerialName("is_new") val isNew: Boolean?,
    @SerialName("is_active") val isActive: Boolean?,
    @SerialName("type") val type: String?,
)
