package com.mediaproject.admin.screen.landing.signup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.admin.common.theme.gray1
import com.mediaproject.admin.common.theme.green1
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpScreenBottomBar(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
    onClickSignUp: () -> Unit = {},
) {
    val isEnable: Boolean = (
        uiState!!.data.isCheckDuplication
            && uiState.data.password == uiState.data.passwordCheckStr
            && checkAll(uiState.data.password)
            && uiState.data.name.isNotEmpty()
    )

    Log.d("BottomBar", isEnable.toString())

    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp)
            .background(gray1),
        contentAlignment = Alignment.Center,
    ) {
        Log.d("TAG", "Refresh $isEnable")
        Button(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp),
            onClick = onClickSignUp,
            colors = if (isEnable) ButtonDefaults.buttonColors(backgroundColor = green1) else ButtonDefaults.buttonColors(backgroundColor = gray1),
            enabled = isEnable,
        ) {
            Text(
                text = "가입하기",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenBottomBarPreView() {
    SignUpScreenBottomBar(uiState = SignUpState.SignUpInit)
}