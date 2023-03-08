package com.mediaproject.presentation.screen.home.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeMenuScreenBody(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun HomeMenuScreenBodyPreview() {
    HomeMenuScreenBody()
}