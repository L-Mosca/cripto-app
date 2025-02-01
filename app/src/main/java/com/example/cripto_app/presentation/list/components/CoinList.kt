package com.example.cripto_app.presentation.list.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cripto_app.R
import com.example.cripto_app.domain.models.CoinGeneralData
import com.example.cripto_app.ui.components.BaseText

@Composable
fun CoinList(
    isLoading: Boolean = false,
    coinList: List<CoinGeneralData> = emptyList(),
    onItemClick: (CoinGeneralData) -> Unit
) {
    AnimatedVisibility(
        visible = !isLoading && coinList.isNotEmpty(),
        enter = fadeIn(animationSpec = tween(500)) + slideInVertically(
            initialOffsetY = { it / 2 },
            animationSpec = tween(500)
        )
    ) {
        LazyColumn {
            item { Spacer(Modifier.height(14.dp)) }
            itemsIndexed(coinList) { _, coin ->
                Column(Modifier.clickable { onItemClick(coin) }) {
                    CoinItem(coin)
                    CoinLine()
                }
            }
        }
    }
}

@Composable
fun CoinItem(coin: CoinGeneralData) {
    if (!coin.name.isNullOrEmpty()) {
        Row(
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CoinName(coin.name)
            CoinIcon(coin.name)
        }
    }
}

@Composable
fun CoinName(coinName: String) {
    BaseText(text = coinName, fontSize = 18.sp)
}

@Composable
fun CoinIcon(coinName: String) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
        contentDescription = coinName,
        tint = colorResource(id = R.color.white),
        modifier = Modifier.size(width = 30.dp, height = 30.dp)
    )
}

@Composable
fun CoinLine() {
    Box(Modifier.padding(horizontal = 20.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(colorResource(R.color.dark_blue_100))
        )
    }
}

@Preview
@Composable
fun CoinListPreview() {
    val list = mutableListOf<CoinGeneralData>()
    val data = CoinGeneralData(
        name = "Nome da moeda",
        id = "",
        symbol = "",
        rank = 2,
        isNew = false,
        isActive = true,
        type = ""
    )
    repeat(10) { list.add(data) }

    CoinList(false, list) {}
}