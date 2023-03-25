package com.mediaproject.presentation.screen.notice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.domain.model.NoticeInfo
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun NoticeScreenBody(
    modifier: Modifier = Modifier,
    itemList: List<NoticeInfo> = listOf(),
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        itemsIndexed(itemList) { index, item ->
            NoticeListItemView(item = item)
            if (index < itemList.lastIndex)
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFF8F9FC),
                    thickness = 1.dp
                )
        }
    }
}

@Composable
fun NoticeListItemView(
    modifier: Modifier = Modifier,
    item: NoticeInfo,
    onClickKind: (item: NoticeInfo) -> Unit = {},
) = Column(
    modifier = Modifier.fillMaxWidth()
        .padding(
            horizontal = 22.dp,
            vertical = 12.dp,
        ),
) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
    val date = LocalDateTime.parse(item.updatedAt, formatter).format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))

    Text(
        text = item.title,
        style = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = date,
        style = TextStyle(
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = gray2,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun NoticeListItemViewPreview() {
    NoticeListItemView(
        item = NoticeInfo(
            title = "지구방위대가 된 걸 환영합니다! 함께 지구를 지켜가요.",
            content = "testContent",
            createdAt = "2023-03-25T09:02:31.516",
            updatedAt = "2023-03-25T09:02:31.516",
        )
    )
}

@Preview(showBackground = true)
@Composable
fun NoticeScreenBodyPreview() {
    NoticeScreenBody(
        itemList = listOf(
            NoticeInfo(
                title = "지구방위대가 된 걸 환영합니다! 함께 지구를 지켜가요.",
                content = "testContent",
                createdAt = "2023-03-25T09:02:31.516",
                updatedAt = "2023-03-25T09:02:31.516",
            ),
            NoticeInfo(
                title = "지구방위대가 된 걸 환영합니다! 함께 지구를 지켜가요.",
                content = "testContent",
                createdAt = "2023-03-25T09:02:31.516",
                updatedAt = "2023-03-25T09:02:31.516",
            ),
            NoticeInfo(
                title = "지구방위대가 된 걸 환영합니다! 함께 지구를 지켜가요.",
                content = "testContent",
                createdAt = "2023-03-25T09:02:31.516",
                updatedAt = "2023-03-25T09:02:31.516",
            ),
            NoticeInfo(
                title = "지구방위대가 된 걸 환영합니다! 함께 지구를 지켜가요.",
                content = "testContent",
                createdAt = "2023-03-25T09:02:31.516",
                updatedAt = "2023-03-25T09:02:31.516",
            ),
        )
    )
}