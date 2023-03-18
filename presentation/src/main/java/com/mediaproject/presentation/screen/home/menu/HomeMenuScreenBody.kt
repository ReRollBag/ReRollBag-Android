package com.mediaproject.presentation.screen.home.menu

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrow
import com.mediaproject.presentation.common.theme.*
import com.mediaproject.presentation.widgets.states.HomeMenuState

@Composable
fun HomeMenuScreenBody(
    modifier: Modifier = Modifier,
    userState: HomeMenuState = HomeMenuState.Init,
    onClickSignOut: () -> Unit = {},
    onClickRentList: () -> Unit = {},
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        HomeMenuBodyUserInfoWidget(userState = userState)
        Spacer(modifier = Modifier.height(40.dp))
    //region feature
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
                .border(width = 1.dp, color = gray1, shape = RoundedCornerShape(8.dp))
                .background(color = gray1, shape = RoundedCornerShape(8.dp))
                .padding(all = 10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClickRentList() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "대여목록",
                    style = TextStyle(
                        fontSize = 13.sp
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
                    .clickable {

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "공지사항",
                    style = TextStyle(
                        fontSize = 13.sp
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
                    .clickable {
                        Toast
                            .makeText(context, "현재 관리자 신청이 불가합니다.", Toast.LENGTH_SHORT)
                            .show()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "관리자 신청",
                    style = TextStyle(
                        fontSize = 13.sp
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
                .border(width = 1.dp, color = gray1, shape = RoundedCornerShape(8.dp))
                .background(color = gray1, shape = RoundedCornerShape(8.dp))
                .padding(all = 10.dp),
        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween,
//            ) {
//                Text(
//                    text = "알림 설정",
//                    style = TextStyle(
//                        fontSize = 13.sp
//                    )
//                )
//                Switch(
//                    modifier = Modifier.scale(0.9f),
//                    checked = false,
//                    onCheckedChange = { condition ->
//
//                    }
//                )
//            }
//            Spacer(modifier = Modifier.height(10.dp))
//            Divider(color = Color(0xFFEFF1F5))
//            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "이용약관",
                    style = TextStyle(
                        fontSize = 13.sp
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
                    .clickable {

                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "개인정보 처리방침",
                    style = TextStyle(
                        fontSize = 13.sp
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
                    .clickable(onClick = onClickSignOut),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "로그아웃",
                    style = TextStyle(
                        fontSize = 13.sp
                    )
                )
                Icon(IconPack.IconArrow, contentDescription = "")
            }
        }

        //endregion

        Spacer(modifier = Modifier.height(30.dp))

        //region bag list
        Text(
            text = "대여 중인 가방",
            style = TextStyle(
                fontSize = 10.sp,
                color = gray2
            )
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .heightIn(min = 120.dp, max = 190.dp)
                .fillMaxWidth()
                .border(width = 1.dp, color = gray1, shape = RoundedCornerShape(20.dp)),
            contentPadding = PaddingValues(horizontal = 25.dp, vertical = 16.dp)
        ) {
            itemsIndexed(userState.listRentingBag) { index, item ->
                HomeMenuListItemWidget(item = item)
                if (index < userState.listRentingBag.lastIndex)
                    Divider(color = gray1, thickness = 1.dp)
            }
        }
        //endregion

    }
}

@Preview(showBackground = true)
@Composable
fun HomeMenuScreenBodyPreview() {
    Column {
        HomeMenuScreenBody(
            userState = HomeMenuState.Update(
                updateUserId = "test@gmail.com",
                updateUserName = "test",
                updateListRentingBag = listOf(
                    BagInfo(
                        bagsId = "KOR_SUWON_1",
                        whenIsRented = "2023-03-09T08:02:38.278",
                        rentingUsersId = "testUsersId",
                        rented = true,
                        whenIsReturned = "",
                        isReturning = false
                    ),
                    BagInfo(
                        bagsId = "KOR_SUWON_2",
                        whenIsRented = "2023-03-09T08:02:38.278",
                        rentingUsersId = "testUsersId",
                        rented = true,
                        whenIsReturned = "",
                        isReturning = false
                    ),
                    BagInfo(
                        bagsId = "KOR_SUWON_3",
                        whenIsRented = "2023-03-09T08:02:38.278",
                        rentingUsersId = "testUsersId",
                        rented = true,
                        whenIsReturned = "",
                        isReturning = false
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeMenuScreenBodyEmptyPreview() {
    Column {
        HomeMenuScreenBody(
            userState = HomeMenuState.Update(
                updateUserId = "test@gmail.com",
                updateUserName = "test",
                updateListRentingBag = listOf()
            )
        )
    }
}