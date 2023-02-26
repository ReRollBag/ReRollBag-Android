package com.mediaproject.presentation.screen.home.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeMenuScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {},
) = Scaffold(
    topBar = {
        HomeMenuAppBar {
            onBackPressed()
        }
    }
) { padding ->
    HomeMenuScreenBody(
        modifier = modifier.padding(padding)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeMenuScreenPreview() {
    HomeMenuScreen()
}