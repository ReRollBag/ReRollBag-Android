package com.mediaproject.presentation.screen.user.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.core.model.NoticeInfo
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrow

@Composable
fun UserHomeNoticeScreen(
    modifier: Modifier = Modifier,
    noticeInfo: com.mediaproject.core.model.NoticeInfo,
    onClickNotice: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .heightIn(min = 36.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xCC777986)
            )
            .padding(horizontal = 8.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClickNotice
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = noticeInfo.title,
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.White
                )
            )
            Icon(
                IconPack.IconArrow,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomeNoticeScreenPreview() {
    UserHomeNoticeScreen(
        noticeInfo = com.mediaproject.core.model.NoticeInfo(
            title = "testTitle1",
            content = "testContent1",
            createdAt = "2023-03-23T04:37:18.11",
            updatedAt = "2023-03-23T04:37:18.11",
        )
    )
}