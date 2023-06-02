package com.mediaproject.presentation.screen.user.home.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.*
import com.mediaproject.presentation.widgets.states.HomeMenuState

@Composable
fun HomeMenuBodyUserInfoWidget(
    modifier: Modifier = Modifier,
    userState: HomeMenuState = HomeMenuState.Init,
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .heightIn(max = 64.dp),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .border(width = 1.dp, color = gray1, shape = CircleShape)
            .background(color = ivory1, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "user",
            contentScale = ContentScale.Fit,
        )
    }
    Spacer(modifier = Modifier.width(12.dp))
    Column {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = when (userState.userName.isEmpty()) {
                    true -> "홍길동"
                    false -> userState.userName
                },
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "지구방위대원",
                style = TextStyle(
                    fontSize = 10.sp,
                    color = gray2
                )
            )
        }
        Text(
            text = "${
                userState.listRentingBag.size
                + userState.listReturningBag.size
                + userState.listReturnedBag.size
            }번째 비닐 격퇴 성공!",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = ivory3
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeMenuBodyUserInfoWidgetPreview() {
    HomeMenuBodyUserInfoWidget()
}