package com.example.cripto_app.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cripto_app.R
import com.example.cripto_app.domain.models.CoinGeneralData
import com.example.cripto_app.navigation.Screen
import com.example.cripto_app.presentation.list.components.CoinList
import com.example.cripto_app.presentation.list.components.CoinListLoading

@Composable
fun ListScreen(navController: NavHostController, viewModel: ListViewModel = hiltViewModel()) {

    val isLoading = viewModel.isLoading.value
    val coinList = viewModel.coinList.value

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.dark_blue_600))
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            CoinList(
                isLoading,
                coinList,
                onItemClick = { coin -> navigateToDetailScreen(navController, coin) })
            if (isLoading) CoinListLoading(true)
        }
    }
}

fun navigateToDetailScreen(navController: NavHostController, coin: CoinGeneralData) {
    navController.navigate(Screen.Detail.route + "/${coin.id}")
}

@Composable
@Preview
fun ListScreenPreview() {
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

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.dark_blue_600))
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            CoinListLoading(true)
            CoinList(true, list) {}
        }
    }
}