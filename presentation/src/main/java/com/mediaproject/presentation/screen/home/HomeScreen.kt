package com.mediaproject.presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) = Scaffold(
    topBar = { HomeScreenAppBar() },
) { padding ->
    HomeScreenBody(
        modifier = modifier.padding(padding),
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}