package com.mediaproject.presentation.screen.admin.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.core.model.BagInfo
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun AdminReturningBagItemDialog(
    modifier: Modifier = Modifier,
    bagInfo: BagInfo,
    clearQrScanState: () -> Unit = {},
    onClickReturnedBag: (bagId: String) -> Unit = {},
) = AlertDialog(
    onDismissRequest = {
        clearQrScanState()
    },
    buttons = {
        val interactionSourceSuccess = remember { MutableInteractionSource() }
        val isPressedSuccess by interactionSourceSuccess.collectIsPressedAsState()

        val interactionSourceFail = remember { MutableInteractionSource() }
        val isPressedFail by interactionSourceFail.collectIsPressedAsState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                modifier = Modifier.widthIn(min = 100.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = green1
                ),
                interactionSource = interactionSourceSuccess,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isPressedSuccess) green1 else Color.White,
                ),
                onClick = {
                    onClickReturnedBag(bagInfo.bagsId)
                }
            ) {
                Text(
                    text = "확인",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = if (isPressedSuccess) Color.White else Color.Black
                    )
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                modifier = Modifier.widthIn(min = 100.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = green1
                ),
                interactionSource = interactionSourceFail,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isPressedFail) green1 else Color.White,
                ),
                onClick = {
                    clearQrScanState()
                }
            ) {
                Text(
                    text = "취소",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = if (isPressedFail) Color.White else Color.Black
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    },
    title = {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "반납을 확정하시겠습니까?",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    },
    text = {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val currentTime = LocalDateTime.now();
        val startDate = LocalDateTime.parse(bagInfo.whenIsRented, formatter).format(DateTimeFormatter.ofPattern("MM.dd"))
        val endDate = currentTime.format(DateTimeFormatter.ofPattern("MM.dd"))


        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row {
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
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = bagInfo.bagsId,
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
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
                                color = Color.Black
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
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        )
                    }
                }
            }
        }
    },
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    backgroundColor = Color.White
)

@Composable
fun AdminCancelDialog(
    modifier: Modifier = Modifier,
    clearQrScanState: () -> Unit = {},
) = AlertDialog(
    onDismissRequest = {
        clearQrScanState()
    },
    buttons = {
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = green1
                ),
                interactionSource = interactionSource,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isPressed) green1 else Color.White,
                ),
                onClick = {
                    clearQrScanState()
                }
            ) {
                Text(
                    text = "확인",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = if (isPressed) Color.White else Color.Black
                    )
                )
            }
        }
    },
    title = {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "QR코드가 인식되지 않습니다.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    },
    text = {
        Column {
            Text(
                text = "ㆍ QR코드를 정면에서 촬영해주세요.\n" +
                        "ㆍ 반납 신청 가방의 QR코드가 맞는지 확인해주세요.",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            )
        }
    },
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    backgroundColor = Color.White
)

@Preview(showBackground = true)
@Composable
fun AdminReturningBagItemDialogPreview() {
    AdminReturningBagItemDialog(
        bagInfo = com.mediaproject.core.model.BagInfo(
            bagsId = "KOR_SUWON_1",
            whenIsRented = "2023-03-23T04:37:16.704",
            rentingUsersId = "test@test.com",
            rented = true,
            whenIsReturned = "2023-03-31T04:37:16.704",
            isReturning = false
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AdminCancelDialogPreview() {
    AdminCancelDialog()
}