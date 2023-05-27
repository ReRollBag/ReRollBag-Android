package com.mediaproject.presentation.screen.admin.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconMenuHamburger
import com.mediaproject.presentation.common.theme.green2

@Composable
fun AdminHomeScreenAppBar(
    modifier: Modifier = Modifier,
    onClickMenu: () -> Unit = {},
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp),
    contentAlignment = Alignment.CenterStart
) {
    Icon(
        imageVector = IconPack.IconMenuHamburger,
        contentDescription = "menu",
        modifier = Modifier.padding(
            start = 16.dp
        ).clickable { onClickMenu() },
        tint = green2
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
    AdminHomeScreenAppBar()
}