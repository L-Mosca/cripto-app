package com.example.cripto_app.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetails(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("symbol") val symbol: String?,
    @SerialName("rank") val rank: Int?,
    @SerialName("is_new") val isNew: Boolean?,
    @SerialName("is_active") val isActive: Boolean?,
    @SerialName("type") val type: String?,
    @SerialName("logo") val logo: String?,
    @SerialName("tags") val tags: List<CoinTag>?,
    @SerialName("team") val teams: List<CoinTeam>?,
    @SerialName("description") val description: String?,
    @SerialName("message") val message: String?,
    @SerialName("open_source") val openSource: Boolean?,
    @SerialName("started_at") val startedAt: String?,
    @SerialName("development_status") val developmentStatus: String?,
    @SerialName("hardware_wallet") val hardwareWallet: Boolean?,
    @SerialName("proof_type") val proofType: String?,
    @SerialName("org_structure") val ordStructure: String?,
    @SerialName("hash_algorithm") val hasAlgorithm: String?,
    @SerialName("links") val links: Map<String, List<String>>?,
    @SerialName("links_extended") val linksExtended: List<CoinLinksExtended>?,
    @SerialName("whitepaper") val whitePaper: CoinWhitePaper?,
    @SerialName("first_data_at") val firstData: String?,
    @SerialName("last_data_at") val lastData: String?,

    )

@Serializable
data class CoinTag(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("coin_counter") val coinCounter: Int?,
    @SerialName("ico_counter") val icoCounter: Int?,
)

@Serializable
data class CoinTeam(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("position") val position: String?,
)

@Serializable
data class CoinLinksExtended(
    @SerialName("url") val url: String?,
    @SerialName("type") val type: String?,
    //@SerialName("stats") val stats: Map<String, Int>?,
)

@Serializable
data class CoinWhitePaper(
    @SerialName("link") val link: String?,
    @SerialName("thumbnail") val thumbnail: String?,
)