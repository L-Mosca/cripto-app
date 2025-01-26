package com.example.cripto_app

import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cripto_app.base.BaseActivity
import com.example.cripto_app.base.BaseViewModel
import com.example.cripto_app.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val viewModel: BaseViewModel by viewModels()

    @Composable
    override fun ScreenContent() {
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colorScheme.background) {
            NavGraph(navController = navController)
        }
    }
}