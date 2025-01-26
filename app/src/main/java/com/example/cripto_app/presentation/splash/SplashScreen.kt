package com.example.cripto_app.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cripto_app.R
import com.example.cripto_app.navigation.Screen
import com.example.cripto_app.ui.theme.CryptoTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        delay(2000L)
        goToListScreen(navController)
    }
    AppLogo()
}

private fun goToListScreen(navController: NavHostController) {
    navController.navigate(Screen.List.route) {
        popUpTo(Screen.Splash.route) { inclusive = true }
    }
}

@Composable
fun AppLogo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dark_blue_600)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(width = 240.dp, height = 240.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun SplashPreview() {
    CryptoTheme {
        AppLogo()
    }
}