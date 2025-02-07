package com.example.cripto_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cripto_app.R

@Composable
fun BaseRemoteImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentDescription: String = stringResource(R.string.network_image),
    contentScale: ContentScale = ContentScale.Fit,
    loadingPlaceholder: @Composable () -> Unit = { BaseLoading() },
    errorPlaceholder: @Composable () -> Unit = { ErrorPlaceholder(contentDescription) }
) {
    if (imageUrl.isNullOrEmpty()) return

    var isLoading by remember { mutableStateOf(true) }
    var hasError by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.matchParentSize(),
            alignment = alignment,
            onLoading = {
                isLoading = true
                hasError = false
            },
            onSuccess = {
                isLoading = false
                hasError = false
            },
            onError = {
                isLoading = false
                hasError = true
            },
        )

        if (isLoading) loadingPlaceholder()
        if (hasError) errorPlaceholder()
    }
}

@Composable
fun ErrorPlaceholder(contentDescription: String) {
    Image(
        painter = painterResource(id = R.drawable.img_logo),
        contentDescription = contentDescription,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun BaseRemoteImagePreview() {
}