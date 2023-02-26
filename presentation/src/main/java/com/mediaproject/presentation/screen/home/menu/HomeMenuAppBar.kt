package com.mediaproject.presentation.screen.home.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.R

@Composable
fun HomeMenuAppBar(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {},
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp),
    contentAlignment = Alignment.CenterStart
) {
    Image(
        modifier = Modifier.padding(
            start = 16.dp
        ).clickable { onBackPressed() },
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "back",
    )
    Image(
        modifier = Modifier
            .widthIn(min = 123.dp)
            .heightIn(min = 33.dp)
            .align(Alignment.Center),
        painter = painterResource(id = R.drawable.logo_rerollbag_2),
        contentDescription = "logo",
    )
}

@Preview(showBackground = true)
@Composable
fun HomeMenuAppBarPreview() {
    HomeMenuAppBar()
}