package com.example.cripto_app.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.cripto_app.ui.theme.CryptoTheme

abstract class BaseActivity : ComponentActivity() {
    abstract val viewModel: BaseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent { CryptoTheme { ScreenContent() } }
    }

    @Composable
    abstract fun ScreenContent()
}