package com.mediaproject.presentation.screen.rent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RentListScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {},
) = Scaffold(
    topBar = {
        RentListScreenAppBar {
            onBackPressed()
        }
    }
) { padding ->
    RentListScreenBody(
        modifier = modifier.padding(padding),
    )
}

@Preview(showBackground = true)
@Composable
fun RentListScreenPreview() {
    RentListScreen()
}