package com.example.cripto_app.presentation.details.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cripto_app.R
import com.example.cripto_app.ui.components.BaseLoading

@Composable
fun DetailsLoading(isLoading: Boolean = false) {
    if (!isLoading) return

    BaseLoading(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        color = colorResource(R.color.orange_700)
    )
}

@Preview
@Composable
fun DetailsLoadingPreview() {
    DetailsLoading(isLoading = true)
}