package com.example.cripto_app.presentation.details

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
import com.example.cripto_app.presentation.details.components.CoinDetails
import com.example.cripto_app.presentation.details.components.DetailsLoading

@Composable
fun DetailScreen(navController: NavHostController, viewModel: DetailViewModel = hiltViewModel()) {

    val isLoading = viewModel.isLoading.value
    val coinDetails = viewModel.coinDetails.value

    Scaffold { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(R.color.dark_blue_600)),
            contentAlignment = Alignment.TopCenter,
        ) {
            CoinDetails(coinDetails)
            DetailsLoading(isLoading)
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    Scaffold { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(R.color.dark_blue_600)),
            contentAlignment = Alignment.TopCenter,
        ) {
            CoinDetails(null)
            DetailsLoading(true)
        }
    }
}