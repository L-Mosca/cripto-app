package com.example.cripto_app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cripto_app.R

@Composable
fun BaseLoading(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    color: Color = colorResource(R.color.orange_700)
) {
    Box(modifier, contentAlignment = contentAlignment) {
        CircularProgressIndicator(color = color)
    }
}

@Preview
@Composable
fun BaseLoadingPreview() {
    BaseLoading()
}