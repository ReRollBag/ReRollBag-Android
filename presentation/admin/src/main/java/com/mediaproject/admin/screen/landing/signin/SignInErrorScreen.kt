package com.mediaproject.admin.screen.landing.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.widgets.utils.error.SignInErrorConst

@Composable
private fun SignInErrorText(
    text: String,
) = Text(
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp),
    text = text,
    color = Color.Red,
    style = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight(400),
        lineHeight = 22.sp
    )
)

@Composable
fun SignInErrorScreen(
    condition: Boolean,
    errorMessage: String,
) = when (condition) {
    true -> when (errorMessage) {
        SignInErrorConst.INVALID_USER_EXCEPTION -> SignInErrorText(
            text = "아이디 또는 비밀번호가 일치하지 않습니다."
        )
        SignInErrorConst.NULL_OR_EMPTY_INPUT_EXCEPTION -> SignInErrorText(
            text = "입력한 내용을 다시 확인 해주세요."
        )
        else -> SignInErrorText(
            text = "알 수 없는 오류"
        )
    }
    false -> {}
}

@Preview(showBackground = true)
@Composable
fun SignInErrorScreenPreview() {
    var value by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("UsersIdOrPasswordInvalidException") }

    Column(
//        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // default unknown exception
        SignInErrorScreen(
            condition = true,
            errorMessage = value
        )

        // UsersIdOrPasswordInvalidException
        SignInErrorScreen(
            condition = true,
            errorMessage = value2
        )
    }

}
