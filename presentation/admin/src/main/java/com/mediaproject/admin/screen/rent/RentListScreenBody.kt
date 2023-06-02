package com.mediaproject.admin.screen.rent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.admin.R
import com.mediaproject.admin.common.theme.gray1
import com.mediaproject.admin.common.theme.gray2
import com.mediaproject.admin.common.theme.green2
import com.mediaproject.presentation.widgets.states.RentListState
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun RentListScreenBody(
    modifier: Modifier = Modifier,
    dataState: RentListState = RentListState.Init,
    onClickKind: (kind: String) -> Unit = {},
) = Column(
    modifier = modifier.fillMaxSize()
) {
    Divider(color = gray1, thickness = 1.dp)
    RentListMenuBar(onClickKind = onClickKind)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
//            .border(width = 1.dp, color = gray1),
    ) {
        itemsIndexed(dataState.list) { index, item ->
            ItemView(item = item)
            if (index < dataState.list.lastIndex)
                Divider(color = Color(0xFFF8F9FC), thickness = 1.dp)
        }
    }
}

@Composable
fun RentListMenuBar(
    modifier: Modifier = Modifier,
    onClickKind: (kind: String) -> Unit = {},
) = Row(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 18.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    val kinds = listOf("전체", "반납", "대여중")
    val (selected, setSelected) = remember { mutableStateOf("") }

    LaunchedEffect(true) {
        setSelected(kinds[0])
        onClickKind(kinds[0])
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        green2
        kinds.forEach { item ->
            OutlinedButton(
                onClick = {
                    setSelected(item)
                    onClickKind(item)
                },
                shape = RoundedCornerShape(80.dp),
                border = BorderStroke(
                    1.dp,
                    color = if (selected == item) green2 else gray1
                )
            ) {
                Text(
                    text = item,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = if (selected == item) green2 else gray2
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun ItemView(
    item: BagInfo,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(18.dp))
        Divider(
            color = when (item.whenIsReturned.isEmpty()) {
                true -> Color.Red
                false -> Color.Gray
            },
            modifier = Modifier
                .height(30.dp)
                .width(3.dp)
                .alpha(
                    if (item.whenIsReturned.isNotEmpty()) 1.0f else 0.0f
                )
        )
        Spacer(modifier = Modifier.width(14.dp))
        Surface(
            modifier = Modifier
                .size(64.dp),
            shape = CircleShape,
            elevation = 1.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bag),
                contentDescription = "bag",
                contentScale = ContentScale.None,
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text(
                text = when (item.bagsId.isEmpty()) {
                    true -> "BagId"
                    false -> item.bagsId
                },
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "대여 기간",
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = gray2
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
                val startDate: String
                val endDate: String
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")

                when (item.whenIsReturned.isEmpty()) {
                    true -> {
                        val rentTime = LocalDateTime.parse(item.whenIsRented, formatter)
                        startDate = rentTime.format(DateTimeFormatter.ofPattern("MM.dd"))
                        endDate = rentTime.plusDays(7).format(DateTimeFormatter.ofPattern("MM.dd"))
                    }
                    false -> {
                        startDate = LocalDateTime.parse(item.whenIsRented, formatter).format(DateTimeFormatter.ofPattern("MM.dd"))
                        endDate = LocalDateTime.parse(item.whenIsReturned, formatter).format(DateTimeFormatter.ofPattern("MM.dd"))
                    }
                }

                Text(
                    text = "$startDate ~ $endDate",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
            }
//            Spacer(modifier = Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "대여 장소",
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = gray2
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "GS편의점 우만점",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
            }
        }
        if (item.whenIsReturned.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(end = 18.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Box(
                    modifier = Modifier
                        .background(gray2, shape = RoundedCornerShape(19.dp))
                        .padding(all = 4.dp),
                ) {
                    Text(
                        text = "반납완료",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestItemViewPreview() {
    Column {
        ItemView(
            item = BagInfo(
                bagsId = "KOR_SUWON_1",
                whenIsRented = "2023-03-09T08:02:38.278",
                rentingUsersId = "testUsersId",
                rented = true,
                whenIsReturned = "",
                isReturning = false
            )
        )
        ItemView(
            item = BagInfo(
                bagsId = "KOR_SUWON_1",
                whenIsRented = "2023-03-09T08:02:38.278",
                rentingUsersId = "testUsersId",
                rented = true,
                whenIsReturned = "2023-03-09T08:02:38.278",
                isReturning = false
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RentListScreenBodyPreview() {
    RentListScreenBody()
}