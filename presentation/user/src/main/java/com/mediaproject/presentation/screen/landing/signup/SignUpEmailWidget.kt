package com.mediaproject.presentation.screen.landing.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.core.model.SignUpData
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.common.theme.notoSansFamily
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpEmailWidget(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
    email: String,
    onChangeEmail: (newValue: String) -> Unit = { _ -> },
    onClickCheck: () -> Unit = {},
) = Column(
    modifier = Modifier
        .fillMaxWidth()
) {
    Text(
        text = "이메일",
        style = TextStyle(
            fontFamily = notoSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            lineHeight = 18.sp
        ),
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.widthIn(max = 200.dp)
        ) {
            ReRollBagTextField(
                value = email,
//                onValueChange = { newValue ->
//                    userId = newValue
//                    onChangeEmail(userId)
//                },
                onValueChange = { newValue -> onChangeEmail(newValue) },
                enable = !(uiState!!.data.isCheckDuplication),
            )
            Divider(color = if (uiState.data.isCheckDuplication) green1 else gray1, thickness = 1.dp)
        }
        Button(
            modifier = Modifier.width(100.dp),
            border = BorderStroke(
                width = 1.dp,
                color = if (uiState!!.data.isCheckDuplication) green1 else gray2
            ),
            shape = RoundedCornerShape(25.dp),
//                        enabled = !(uiState.data.isExistUserId),
//            onClick = {
//                if (uiState.data.isCheckDuplication) {
//                    onRefreshCheck(
//                        SignUpData(
//                            userId = email,
//                            isCheckDuplication = !isCheckDuplication,
//                            isErrorDuplication = false,
//                            password = password,
//                            passwordCheckStr = passwordCheckStr,
//                            name = name,
//                        )
//                    )
//                } else {
//                    onDuplicateCheckUserId(
//                        SignUpData(
//                            userId = userId,
//                            isCheckDuplication = isCheckDuplication,
//                            isErrorDuplication = uiState.data.isErrorDuplication,
//                            password = password,
//                            passwordCheckStr = passwordCheckStr,
//                            name = name,
//                        )
//                    )
//                }
//
//            },
            onClick = { onClickCheck() },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = when (uiState.data.isCheckDuplication) {
                    true -> green1
                    false -> gray2
                }
            ),
        ) {
            Text(
                text = when (uiState.data.isCheckDuplication) {
                    true -> "수정"
                    false -> "중복확인"
                },
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 0.sp,
                ),
                modifier = Modifier.height(20.dp)
            )
        }
    }
}