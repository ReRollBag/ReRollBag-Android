package com.mediaproject.admin.screen.rent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.admin.screen.vm.RentListViewModel

@Composable
fun RentListScreen(
    modifier: Modifier = Modifier,
    listViewModel: RentListViewModel = hiltViewModel(),
    onBackPressed: () -> Unit = {},
) = Scaffold(
    topBar = {
        RentListScreenAppBar {
            onBackPressed()
        }
    }
) { padding ->
    val listState = listViewModel.listState.observeAsState()

    listState.value?.let {
        RentListScreenBody(
            modifier = modifier.padding(padding),
            dataState = it
        ) { kind ->
            listViewModel.getListData(kind = kind)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RentListScreenPreview() {
    RentListScreen()
}