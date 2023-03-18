package com.mediaproject.presentation.screen.rent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
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
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.green2
import com.mediaproject.presentation.widgets.states.RentListState

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
            .border(width = 1.dp, color = gray1),
    ) {
        itemsIndexed(dataState.list) { index, item ->
            ItemView(item = item)
            if (index < dataState.list.lastIndex)
                Divider(color = gray1, thickness = 1.dp)
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
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(18.dp))
        Divider(
            color = Color.Red,
            modifier = Modifier
                .height(30.dp)
                .width(3.dp)
                .alpha(0.0f)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Box(
            modifier = Modifier
                .size(64.dp)
                .border(width = 0.dp, color = gray2, shape = CircleShape)
                .background(color = green1, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bag),
                contentDescription = "bag",
                contentScale = ContentScale.Fit,
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
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
                Text(
                    text = "03.17 ~ 03.31",
                    style = TextStyle(
                        fontSize = 13.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
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
                    )
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestItemViewPreview() {
    ItemView(
        item = BagInfo(
            bagsId = "KOR_SUWON_1",
            whenIsRented = "2023-03-09T08:02:38.278",
            rentingUsersId = "testUsersId",
            rented = true,
            isReturning = false
        )
    )
}

@Preview(showBackground = true)
@Composable
fun RentListScreenBodyPreview() {
    RentListScreenBody()
}