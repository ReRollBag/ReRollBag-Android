package com.mediaproject.presentation.screen.landing.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrowBack
import com.mediaproject.presentation.common.theme.notoSansFamily

@Composable
fun SignUpAppBarView(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {},
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp),
    contentAlignment = Alignment.CenterStart
) {
    Icon(
        IconPack.IconArrowBack,
        modifier = Modifier.padding(
            start = 16.dp
        ).clickable(onClick = onBackPress),
        contentDescription = "back",
    )
    Text(
        "회원가입",
        modifier = Modifier.align(Alignment.Center),
        style = TextStyle(
            fontFamily = notoSansFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            lineHeight = 41.sp
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpAppBarViewPreview() {
    SignUpAppBarView()
}