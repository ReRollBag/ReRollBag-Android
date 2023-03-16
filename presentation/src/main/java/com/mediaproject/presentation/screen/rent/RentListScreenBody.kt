package com.mediaproject.presentation.screen.rent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.green2

@Composable
fun RentListScreenBody(
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier.fillMaxSize()
) {
    RentListMenuBar()
}

@Composable
fun RentListMenuBar(
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 18.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    val kinds = listOf("전체", "반납", "대기중")
    val (selected, setSelected) = remember { mutableStateOf("") }

    LaunchedEffect(true) {
        setSelected(kinds[0])
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        green2
        kinds.forEach { item ->
            OutlinedButton(
                onClick = {
                    setSelected(item)
                },
                shape = RoundedCornerShape(80.dp),
                border = BorderStroke(
                    1.dp,
                    color = if (selected == item) green2 else gray1
                )
            ) {
                Text(
                    text = item,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = if (selected == item) green2 else gray2
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RentListScreenBodyPreview() {
    RentListScreenBody()
}