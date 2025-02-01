package com.example.cripto_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImagePainter
import com.example.cripto_app.R

@Composable
fun BaseRemoteImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    contentDescription: String = stringResource(R.string.network_image),
    loadingPlaceholder: @Composable () -> Unit = { BaseLoading() },
    errorPlaceholder: @Composable () -> Unit = { ErrorPlaceholder(contentDescription) }
) {
    if (imageUrl.isNullOrEmpty()) return

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build()
    )

    val state = painter.state

    Box(modifier = modifier, contentAlignment = contentAlignment) {
        when (state) {
            is AsyncImagePainter.State.Loading -> loadingPlaceholder()
            is AsyncImagePainter.State.Error -> errorPlaceholder()
            else -> Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize()
            )
        }
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