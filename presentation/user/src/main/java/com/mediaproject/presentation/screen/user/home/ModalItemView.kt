package com.mediaproject.presentation.screen.user.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.core.model.RentingMarker
import com.mediaproject.core.model.ReturningMarker
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconQrScan
import com.mediaproject.presentation.common.component.icons.iconpack.IconRent
import com.mediaproject.presentation.common.component.icons.iconpack.IconReturn
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.green2

@Composable
fun RentModalItemView(
    modifier: Modifier = Modifier,
    marker: com.mediaproject.core.model.RentingMarker,
    onClickQrScan: () -> Unit = {},
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 60.dp)
        .padding(vertical = 24.dp, horizontal = 20.dp),
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier
                .heightIn(min = 80.dp)
                .widthIn(min = 80.dp),
            backgroundColor = green1,
            shape = RoundedCornerShape(8.dp),
        ) {
            Icon(
                IconPack.IconRent,
                contentDescription = "rent",
                tint = Color.White,
                modifier = Modifier.scale(0.5f),
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Column(
            modifier = Modifier.padding(vertical = 9.dp)
        ) {
            Text(
                text = marker.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "대여 가능한 가방 갯수",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = gray2
                )
            )
            Text(
                text = "${marker.currentBagsNum} / ${marker.maxBagsNum}개",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 46.dp),
        onClick = {
            onClickQrScan()
        },
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.buttonColors(backgroundColor = green1)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                IconPack.IconQrScan,
                contentDescription = "qr_scan",
                tint = Color.White
            )
            Spacer(modifier = Modifier.widthIn(7.dp))
            Text(
                text = "QR코드 촬영",
                style = TextStyle(
//                    fontFamily = notoSansFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White,
                ),
            )
        }
    }
}

@Composable
fun ReturningModalItemView(
    modifier: Modifier = Modifier,
    marker: com.mediaproject.core.model.ReturningMarker,
    onClickQrScan: () -> Unit = {},
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 60.dp)
        .padding(vertical = 24.dp, horizontal = 20.dp),
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier
                .heightIn(min = 80.dp)
                .widthIn(min = 80.dp),
            backgroundColor = Color(0xFF3CA5FF),
            shape = RoundedCornerShape(8.dp),
        ) {
            Icon(
                IconPack.IconReturn,
                contentDescription = "return",
                tint = Color.White,
                modifier = Modifier.scale(0.5f)
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Column(
            modifier = Modifier.padding(vertical = 9.dp)
        ) {
            Text(
                text = marker.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "위치가 확인되었습니다.\n반납하려면 QR코드를 촬영해주세요.",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = gray2
                )
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 46.dp),
        onClick = {
            onClickQrScan()
        },
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.buttonColors(backgroundColor = green1)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                IconPack.IconQrScan,
                contentDescription = "qr_scan",
                tint = Color.White
            )
            Spacer(modifier = Modifier.widthIn(7.dp))
            Text(
                text = "QR코드 촬영",
                style = TextStyle(
//                    fontFamily = notoSansFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RentModalItemViewPreview() {
    RentModalItemView(
        marker = com.mediaproject.core.model.RentingMarker(
            latitude = 37.0,
            longitude = 127.0,
            name = "GS편의점 우만점",
            maxBagsNum = 10,
            currentBagsNum = 10,
            imageUrl = ""
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ReturningItemViewPreview() {
    ReturningModalItemView(
        marker = com.mediaproject.core.model.ReturningMarker(
            latitude = 37.0,
            longitude = 127.0,
            name = "GS편의점 우만점",
            imageUrl = ""
        )
    )
}