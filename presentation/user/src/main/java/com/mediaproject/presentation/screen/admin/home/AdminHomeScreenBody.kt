package com.mediaproject.presentation.screen.admin.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AdminHomeScreenBody(
    modifier: Modifier = Modifier,
) = Box(modifier = modifier.fillMaxSize()) {

}

@Preview(showBackground = true)
@Composable
fun AdminHomeScreenBodyPreview() {
    AdminHomeScreenBody()
}