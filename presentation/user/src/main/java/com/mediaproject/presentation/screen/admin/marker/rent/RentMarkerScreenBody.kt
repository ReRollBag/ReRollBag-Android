package com.mediaproject.presentation.screen.admin.marker.rent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.green2
import com.mediaproject.presentation.common.theme.notoSansFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RentMarkerScreenBody(
    modifier: Modifier = Modifier,
    onChangeLatitude: (Double) -> Unit = {},
    onChangeLongitude: (Double) -> Unit = {},
    onChangeName: (String) -> Unit = {},
    onChangeMaxBagsNumber: (Int) -> Unit = {},
    onClickSave: () -> Unit = {}
) = Column(
    modifier = modifier.fillMaxSize()
        .background(color = Color.White)
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 32.dp),
) {
    var latitude by rememberSaveable { mutableStateOf("") }
    var longitude by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var maxBagsNumber by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "위도",
            style = TextStyle(
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                ReRollBagTextField(
                    value = latitude,
                    onValueChange = {
                        kotlin.runCatching {
                            onChangeLatitude(it.toDouble())
                            latitude = it
                        }
                    },
                    hint = "위도를 입력해주세요",
                    keyboardType = KeyboardType.Number
                )
                Divider(
                    color = if (latitude.isEmpty()) gray1 else green2,
                    thickness = 1.dp
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "경도",
            style = TextStyle(
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                ReRollBagTextField(
                    value = longitude,
                    onValueChange = {
                        kotlin.runCatching {
                            onChangeLongitude(it.toDouble())
                            longitude = it
                        }
                    },
                    hint = "경도를 입력해주세요",
                    keyboardType = KeyboardType.Number
                )
                Divider(
                    color = if (longitude.isEmpty()) gray1 else green2,
                    thickness = 1.dp
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "장소 이름",
            style = TextStyle(
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                ReRollBagTextField(
                    value = name,
                    onValueChange = {
                        onChangeName(it)
                        name = it
                    },
                    hint = "장소 이름를 입력해주세요"
                )
                Divider(
                    color = if (name.isEmpty()) gray1 else green2,
                    thickness = 1.dp
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "최대 가방 개수",
            style = TextStyle(
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                ReRollBagTextField(
                    value = maxBagsNumber,
                    onValueChange = {
                        kotlin.runCatching {
                            onChangeMaxBagsNumber(it.toInt())
                            maxBagsNumber = it
                        }
                    },
                    hint = "최대 가방 개수를 입력해주세요",
                    keyboardType = KeyboardType.Number
                )
                Divider(
                    color = if (maxBagsNumber.isEmpty()) gray1 else green2,
                    thickness = 1.dp
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
    Card(
        shape = RoundedCornerShape(25.dp),
        modifier = modifier
            .height(44.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(25.dp))
            .combinedClickable(
                onLongClick = {},
                onClick = onClickSave
            ),
        backgroundColor = green1,
        elevation = 0.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "등록",
                style = TextStyle(
                    fontWeight = FontWeight(700),
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                    color = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RentMarkerScreenBodyPreview() {
    RentMarkerScreenBody()
}