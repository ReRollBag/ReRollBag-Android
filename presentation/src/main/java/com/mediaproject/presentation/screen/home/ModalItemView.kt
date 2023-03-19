package com.mediaproject.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.green2
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Composable
fun RentItemView(
    modifier: Modifier = Modifier,
    bagId: String = "",
    clearQrScanState: () -> Unit = {},
    onClickRentBag: (bagId: String) -> Unit = {},
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
            Column {

            }
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
                    onClickRentBag(bagId)
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
                text = "대여를 확정하시겠습니까?",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    },
    text = {
//        val rentTime = LocalDateTime.now();
//        val startDate = rentTime.format(DateTimeFormatter.ofPattern("MM.dd"))
//        val endDate = rentTime.plusDays(7).format(DateTimeFormatter.ofPattern("MM.dd"))

        val startDate = "03.17"
        val endDate = "03.24"
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
//            Box(
//                modifier = Modifier
//                    .size(64.dp)
//                    .border(width = 0.dp, color = gray2, shape = CircleShape)
//                    .background(color = green1, shape = CircleShape),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_bag),
//                    contentDescription = "bag",
//                    contentScale = ContentScale.Fit,
//                )
//            }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = bagId,
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
fun ReturningItemView(
    modifier: Modifier = Modifier,
    bagId: String = "",
    onClickRequestRenting: (bagId: String) -> Unit = {},
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 60.dp)
        .padding(vertical = 10.dp),
    verticalAlignment = Alignment.CenterVertically
) {
//    var startDate: String
//    var endDate: String
//
//    try {
//        val rentTime = LocalDateTime.parse(item.whenIsRented, formatter)
//        startDate = rentTime.format(DateTimeFormatter.ofPattern("MM.dd"))
//        endDate = rentTime.plusDays(7).format(DateTimeFormatter.ofPattern("MM.dd"))
//    } catch (e: Exception) {
//        startDate = "00.00"
//        endDate = "00.00"
//    }

    Spacer(modifier = Modifier.width(18.dp))
    Divider(
        color = Color.Red,
        modifier = Modifier
            .height(30.dp)
            .width(3.dp)
            .alpha(0.0f)
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
//    Box(
//        modifier = Modifier
//            .size(64.dp)
//            .border(width = 0.dp, color = gray2, shape = CircleShape)
//            .background(color = green1, shape = CircleShape),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_bag),
//            contentDescription = "bag",
//            contentScale = ContentScale.Fit,
//        )
//    }
    Spacer(modifier = Modifier.width(20.dp))
    Column {
        Text(
            text = bagId,
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
                    fontWeight = FontWeight.Medium,
                )
            )
        }
//        Spacer(modifier = Modifier.height(4.dp))
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
    Spacer(modifier = Modifier.width(20.dp))
    Button(
        border = BorderStroke(
            width = 1.dp,
            color = green1
        ),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = green2
        ),
        onClick = {
            onClickRequestRenting(bagId)
        }
    ) {
        Text(
            text = "반납 신청",
            style = TextStyle(
                fontSize = 13.sp,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RentItemViewPreview() {
    RentItemView(bagId = "KOR_SUWON_1")
}

@Preview(showBackground = true)
@Composable
fun ReturningItemViewPreview() {
    ReturningItemView(bagId = "KOR_SUWON_1")
}