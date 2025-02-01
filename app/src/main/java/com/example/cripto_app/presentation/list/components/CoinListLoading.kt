package com.example.cripto_app.presentation.list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cripto_app.R

@Composable
fun CoinListLoading(isLoading: Boolean) {
    if (isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = colorResource(id = R.color.orange_700))
        }
    }
}

@Preview
@Composable
fun CoinListLoadingPreview() {
    CoinListLoading(true)
}