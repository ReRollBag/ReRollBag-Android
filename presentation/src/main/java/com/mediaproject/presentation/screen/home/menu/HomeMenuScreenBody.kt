package com.mediaproject.presentation.screen.home.menu

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.*

@Composable
fun HomeMenuScreenBody(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        //region Name Space
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 64.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.size(64.dp),
                onClick = {
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = ivory1)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "google",
                    contentScale = ContentScale.Fit,
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "홍길동",
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
                    text = "0번째 비닐 격퇴 성공!",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = ivory3
                    )
                )
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
                .fillMaxWidth()
                .border(width = 1.dp, color = gray1, shape = RoundedCornerShape(20.dp)),
//                .shadow(elevation = 1.dp, shape = RoundedCornerShape(20.dp))
            contentPadding = PaddingValues(horizontal = 25.dp, vertical = 16.dp)
        ) {
            val testList = listOf(0, 1, 2)
            itemsIndexed(testList) { index, item ->
                TestItemView(key = item)
                if (index < testList.lastIndex)
                    Divider(color = gray1, thickness = 1.dp)
            }
        }
        //endregion

        Spacer(modifier = Modifier.height(40.dp))

        //region my page

//        val numbers = (0..20).toList()
//
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2)
//        ) {
//            items(numbers.size) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Text(text = "Number")
//                    Text(text = "  $it",)
//                }
//            }
//        }
        //endregion
    }
}

@Composable
fun TestItemView(
    key: Int = 0,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .border(width = 0.dp, color = gray2, shape = CircleShape)
                .background(color = green1, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bag),
                contentDescription = "google",
                contentScale = ContentScale.Fit,
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = "BagId$key",
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
                    text = "03.17 ~ 03.31",
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
    TestItemView()
}

@Preview(showBackground = true)
@Composable
fun HomeMenuScreenBodyPreview() {
    HomeMenuScreenBody()
}