package com.mediaproject.presentation.screen.home

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
fun HomeScreenAppBar(
    modifier: Modifier = Modifier,
    onClickMenu: () -> Unit = {},
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp),
    contentAlignment = Alignment.CenterStart
) {
    Image(
        modifier = Modifier.padding(
            start = 16.dp
        ).clickable { onClickMenu() },
        painter = painterResource(id = R.drawable.ic_menu_hamburger),
        contentDescription = "menu",
    )
    Image(
        modifier = Modifier
            .widthIn(max = 123.dp)
            .heightIn(max = 33.dp)
            .align(Alignment.Center),
        painter = painterResource(id = R.drawable.logo_rerollbag),
        contentDescription = "logo",
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenAppBarPreview() {
    HomeScreenAppBar()
}