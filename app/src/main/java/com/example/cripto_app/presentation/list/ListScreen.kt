package com.example.cripto_app.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cripto_app.R

@Composable
fun ListScreen(navController: NavHostController, viewModel: ListViewModel = hiltViewModel()) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.blue_400))
                .fillMaxSize()
        ) {}
    }
}

@Composable
@Preview
fun ListScreenPreview() {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.blue_400))
                .fillMaxSize()
        ) {}
    }
}