package com.mediaproject.presentation.screen.user.notice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.NoticeViewModel

@Composable
fun NoticeScreen(
    modifier: Modifier = Modifier,
    noticeViewModel: NoticeViewModel = hiltViewModel(),
    onBackPressed: () -> Unit = {}
) = Scaffold(
    topBar = {
        NoticeScreenAppBar {
            onBackPressed()
        }
    }
) { padding ->
    val noticeState = noticeViewModel.noticeState.observeAsState()

    LaunchedEffect(true) {
        noticeViewModel.getNoticeListByAll()
    }

    noticeState.value?.let { state ->
        NoticeScreenBody(
            modifier = Modifier.padding(padding),
            itemList = state.noticeList
        )
    }
}