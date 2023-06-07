package com.mediaproject.presentation.screen.admin.notice

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.AdminNoticeViewModel
import com.mediaproject.presentation.widgets.states.AdminNoticeState

@Composable
fun AdminNoticeScreen(
    modifier: Modifier = Modifier,
    noticeViewModel: AdminNoticeViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
) = Scaffold(
    topBar = {
        AdminNoticeScreenAppBar {
            onClickBack()
        }
    },
) { padding ->
    val uiState = noticeViewModel.state.observeAsState()
    if (uiState.value is AdminNoticeState.Success) {
        LaunchedEffect(true) {
            onClickBack()
        }
    }
    AdminNoticeScreenBody(
        modifier = modifier.padding(padding),
        onChangeTitle = noticeViewModel::onChangeTitle,
        onChangeContent = noticeViewModel::onChangeContent,
        onClickSave = noticeViewModel::saveNotice
    )
}