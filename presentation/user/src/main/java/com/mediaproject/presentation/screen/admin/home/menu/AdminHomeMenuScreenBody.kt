package com.mediaproject.presentation.screen.admin.home.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrow
import com.mediaproject.presentation.common.component.icons.iconpack.IconRefreshList
import com.mediaproject.presentation.common.theme.*
import com.mediaproject.presentation.widgets.states.AdminHomeMenuState
import com.mediaproject.presentation.widgets.states.HomeMenuState

@Composable
fun AdminHomeMenuScreenBody(
    modifier: Modifier = Modifier,
    userState: AdminHomeMenuState = AdminHomeMenuState.Init,
    onClickNotice: () -> Unit = {},
    onClickBag: () -> Unit = {},
    onClickRentMarker: () -> Unit = {},
    onClickReturnedMarker: () -> Unit = {},
    onClickSignOut: () -> Unit = {},
) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .background(color = Color.White)
    ) {
        AdminHomeMenuBodyUserInfoWidget(userState = userState)

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "기능",
            style = TextStyle(
                fontSize = 10.sp,
                color = gray2
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF6F7F8),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(all = 10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClickNotice
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "공지사항 등록",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color(0xFFEFF1F5))
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClickBag
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "가방 등록",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color(0xFFEFF1F5))
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClickRentMarker
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "대여 장소 등록",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color(0xFFEFF1F5))
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClickReturnedMarker
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "반납 장소 등록",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
        }

        //endregion

        Spacer(modifier = Modifier.height(40.dp))

        //region feature
        Text(
            text = "어플리케이션 설정",
            style = TextStyle(
                fontSize = 10.sp,
                color = gray2
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF6F7F8),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(all = 10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "이용약관",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color(0xFFEFF1F5))
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "개인정보 처리방침",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color(0xFFEFF1F5))
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClickSignOut
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "로그아웃",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
        }

        //endregion

        Spacer(modifier = Modifier.height(30.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun UserHomeMenuScreenBodyPreview() {
    Column {
        AdminHomeMenuScreenBody(
            userState = AdminHomeMenuState.Update(
                userId = "test@gmail.com",
                userName = "test",
            )
        )
    }
}