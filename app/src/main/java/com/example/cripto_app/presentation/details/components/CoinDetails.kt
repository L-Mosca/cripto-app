package com.example.cripto_app.presentation.details.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cripto_app.R
import com.example.cripto_app.domain.models.CoinDetails
import com.example.cripto_app.domain.models.CoinWhitePaper
import com.example.cripto_app.ui.components.BaseRemoteImage
import com.example.cripto_app.ui.components.BaseText

@Composable
fun CoinDetails(details: CoinDetails? = null) {
    if (details == null) return

    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(500)) + slideInVertically(
            initialOffsetY = { it / 2 },
            animationSpec = tween(500)
        )
    ) {
        LazyColumn(Modifier.background(colorResource(R.color.dark_blue_600))) {
            item { Spacer(Modifier.height(14.dp)) }
            item { CoinName(details.name) }
            item { Spacer(Modifier.height(20.dp)) }
            item { CoinDescription(details.description) }
            item { CoinDetailImage(details.logo) }
            item { Spacer(Modifier.height(14.dp)) }
        }
    }
}

@Composable
fun CoinName(name: String?) {
    if (name.isNullOrEmpty()) return

    BaseText(
        text = name,
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
        color = colorResource(R.color.white),
        fontWeight = FontWeight.W500,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CoinDescription(description: String?) {
    if (description.isNullOrEmpty()) return

    BaseText(
        text = description,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        color = colorResource(R.color.blue_100),
        fontWeight = FontWeight.W400,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    )
}

@Composable
fun CoinDetailImage(imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) return

    BaseRemoteImage(
        imageUrl = imageUrl,
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp, 100.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun CoinDetailsPreview() {
    val data = CoinDetails(
        name = "Nome da Moeda",
        id = "",
        symbol = "Simbolo",
        rank = 1,
        isNew = true,
        isActive = true,
        type = "Tipo",
        logo = "https://static.coinpaprika.com/coin/btc-bitcoin/logo.png",
        tags = emptyList(),
        teams = emptyList(),
        description = "Descrição da moeda",
        message = "",
        openSource = true,
        startedAt = "",
        developmentStatus = "",
        hardwareWallet = true,
        proofType = "Proof Type",
        ordStructure = "Ord Structure",
        hasAlgorithm = "Has Algorithm",
        links = emptyMap(),
        linksExtended = emptyList(),
        whitePaper = CoinWhitePaper(link = "", thumbnail = ""),
        firstData = "",
        lastData = "",
    )
    CoinDetails(data)
}