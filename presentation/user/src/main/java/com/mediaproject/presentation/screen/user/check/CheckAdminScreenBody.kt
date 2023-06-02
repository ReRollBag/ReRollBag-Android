package com.mediaproject.presentation.screen.user.check

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
import androidx.compose.ui.draw.alpha
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
import com.mediaproject.presentation.widgets.states.CheckAdminState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckAdminScreenBody(
    modifier: Modifier = Modifier,
    state: CheckAdminState = CheckAdminState.Init,
    onChangeRegion: (String) -> Unit = { _ -> },
    onChangeCertification: (Int) -> Unit = {_ -> },
    onClickApply: () -> Unit = {},
    onClickSetUp: () -> Unit = {}
) = Column(
    modifier = modifier
        .background(color = Color.White)
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 32.dp),
    verticalArrangement = Arrangement.Center
) {
    var validNumber by rememberSaveable { mutableStateOf("") }
    var region by rememberSaveable { mutableStateOf("") }

    Text("발급 받은 인증번호와 관리 지역을 입력해주세요")
    Spacer(modifier = Modifier.height(32.dp))
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "인증 번호",
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
                    value = validNumber,
                    onValueChange = {
                        kotlin.runCatching {
                            onChangeCertification(it.toInt())
                            validNumber = it
                        }
                    },
                    hint = "인증 번호를 입력해주세요",
                    keyboardType = KeyboardType.Number
                )
                Divider(
                    color = if (validNumber.isEmpty()) gray1 else green2,
                    thickness = 1.dp
                )
            }
        }
    }
    if (state is CheckAdminState.Issued) {
        Text(
            text = "* 인증번호가 발급되었습니다.",
            style = TextStyle(
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp,
                color = Color.Red
            ),
            modifier = Modifier.alpha(1.0f)
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "관리 지역",
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
                    value = region,
                    onValueChange = {
                        onChangeRegion(it)
                        region = it
                    },
                    hint = "지역 코드를 입력해주세요"
                )
                Divider(
                    color = if (validNumber.isEmpty()) gray1 else green2,
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
                onClick = onClickSetUp
            ),
        backgroundColor = green1,
        elevation = 0.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "확인",
                style = TextStyle(
                    fontWeight = FontWeight(700),
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                    color = Color.White
                )
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        shape = RoundedCornerShape(25.dp),
        modifier = modifier
            .height(44.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(25.dp))
            .combinedClickable(
                onLongClick = {},
                onClick = onClickApply
            )
            .border(
                border = BorderStroke(2.dp, green1),
                shape = RoundedCornerShape(25.dp)
            ),
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "인증 번호 발급",
                style = TextStyle(
                    fontWeight = FontWeight(700),
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                    color = green1
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckScreenBodyPreview() {
    CheckAdminScreenBody(
        state = CheckAdminState.Init
    )
}