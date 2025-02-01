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

@Composable
fun DetailScreen(navController: NavHostController, viewModel: DetailViewModel = hiltViewModel()) {
    Scaffold { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(R.color.dark_blue_600)),
            contentAlignment = Alignment.TopCenter,
        ) {

        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
}