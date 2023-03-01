package com.mediaproject.presentation.screen.access

import android.util.Log
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.common.theme.gray1
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.screen.vm.AccessViewModel

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

    }
}

@Preview(
    showBackground = true
)
@Composable
fun AccessScreenPreview() {
    AccessScreen()
}