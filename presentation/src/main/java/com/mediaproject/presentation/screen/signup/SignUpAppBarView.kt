package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.theme.ReRollBagTypography

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
    Image(
        modifier = Modifier.padding(
            start = 16.dp
        ).clickable(onClick = onBackPress),
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "back",
    )
    Text(
        "회원가입",
        modifier = Modifier.align(Alignment.Center),
        style = ReRollBagTypography.body
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpAppBarViewPreview() {
    SignUpAppBarView()
}