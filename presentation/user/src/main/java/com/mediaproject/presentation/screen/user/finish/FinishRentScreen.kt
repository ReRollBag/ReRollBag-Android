package com.mediaproject.presentation.screen.user.finish

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.notoSansFamily

@Composable
fun FinishRentScreen(
    modifier: Modifier = Modifier,
    onSuccess: () -> Unit = {},
) = Scaffold(
    bottomBar = {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp)
                .background(gray1),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 80.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = green1),
                onClick = {
                    onSuccess()
                }
            ) {
                Text(
                    text = "지구 지키러 가기",
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }
        }
    }
) { padding ->
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 30.dp,
            ),
        ) {
            Column(
                modifier = Modifier.padding(
                    end = 30.dp,
                    top = 96.dp,
                ),
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = notoSansFamily,
                            )
                        ) {
                            append("대여가 완료되었습니다!")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 16.sp,
                                fontFamily = notoSansFamily,
                            )
                        ) {
                            append("\n회원님 덕분에 지구가 깨끗해지고 있어요!")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(
                        id = R.drawable.image_roll_earth
                    ),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(
                    id = R.drawable.image_finsh_earth
                ),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FinishRentScreenPreview() {
    FinishRentScreen()
}