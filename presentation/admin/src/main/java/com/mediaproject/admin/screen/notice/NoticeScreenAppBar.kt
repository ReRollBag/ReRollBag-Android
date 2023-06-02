package com.mediaproject.admin.screen.notice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.admin.common.component.icons.IconPack
import com.mediaproject.admin.common.component.icons.iconpack.IconArrowBack
import com.mediaproject.admin.common.theme.green2

@Composable
fun NoticeScreenAppBar(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {}
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
        tint = green2
    )
    Text(
        text = "공지사항",
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = green2
        ),
        modifier = Modifier
            .widthIn(max = 123.dp)
            .heightIn(max = 33.dp)
            .align(Alignment.Center),
    )
}

@Preview(showBackground = true)
@Composable
fun NoticeScreenAppBarPreview() {
    NoticeScreenAppBar()
}