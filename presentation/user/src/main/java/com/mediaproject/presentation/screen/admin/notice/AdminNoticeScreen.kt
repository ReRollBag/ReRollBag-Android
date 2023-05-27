package com.mediaproject.presentation.screen.admin.notice

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdminNoticeScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
) = Scaffold(
    topBar = {
        AdminNoticeScreenAppBar {
            onClickBack()
        }
    },
) { padding ->
    AdminNoticeScreenBody(modifier = modifier.padding(padding))
}