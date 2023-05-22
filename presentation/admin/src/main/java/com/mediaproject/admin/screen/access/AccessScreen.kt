package com.mediaproject.admin.screen.access

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
import com.mediaproject.admin.R
import com.mediaproject.admin.common.theme.gray1
import com.mediaproject.admin.common.theme.green1
import com.mediaproject.admin.common.theme.notoSansFamily

@Composable
fun AccessScreen(
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
            .padding(padding)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 30.dp,
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
                        append("가입을 환영합니다!")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 16.sp,
                            fontFamily = notoSansFamily,
                        )
                    ) {
                        append("\n지구방위대가 되어 지구를 지켜주세요!")
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
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(
                    id = R.drawable.image_earth
                ),
                contentDescription = null
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AccessScreenPreview() {
    AccessScreen()
}