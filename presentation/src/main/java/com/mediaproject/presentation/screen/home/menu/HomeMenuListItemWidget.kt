package com.mediaproject.presentation.screen.home.menu

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun HomeMenuListItemWidget(
    item: BagInfo,
) {
    var startDate: String
    var endDate: String

    try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val rentTime = LocalDateTime.parse(item.whenIsRented, formatter)
        startDate = rentTime.format(DateTimeFormatter.ofPattern("MM.dd"))
        endDate = rentTime.plusDays(7).format(DateTimeFormatter.ofPattern("MM.dd"))
    } catch (e: Exception) {
        startDate = "00.00"
        endDate = "00.00"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = Color.Red,
            modifier = Modifier
                .height(30.dp)
                .width(3.dp)
                .alpha(0.0f)
        )
        Spacer(modifier = Modifier.width(12.dp))

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
//        Box(
//            modifier = Modifier
//                .size(64.dp)
////                .border(width = 0.dp, color = gray2, shape = CircleShape)
//                .background(color = green1, shape = CircleShape),
//            contentAlignment = Alignment.Center
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_bag),
//                contentDescription = "bag",
//                contentScale = ContentScale.Fit,
//            )
//        }
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
                    text = "$startDate ~ $endDate",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
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
                    text = "CU편의점 우만점",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeMenuListItemWidgetPreview() {
    HomeMenuListItemWidget(
        item = BagInfo(
            bagsId = "KOR_SUWON_1",
            whenIsRented = "2023-03-09T08:02:38.278",
            rentingUsersId = "testUsersId",
            rented = true,
            whenIsReturned = "",
            isReturning = false
        )
    )
}