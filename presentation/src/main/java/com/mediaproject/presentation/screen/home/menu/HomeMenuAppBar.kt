package com.mediaproject.presentation.screen.home.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrowBack

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
    Icon(
        IconPack.IconArrowBack,
        contentDescription = "back",
        modifier = Modifier.padding(
            start = 16.dp
        ).clickable { onBackPressed() },
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
fun HomeMenuAppBarPreview() {
    HomeMenuAppBar()
}