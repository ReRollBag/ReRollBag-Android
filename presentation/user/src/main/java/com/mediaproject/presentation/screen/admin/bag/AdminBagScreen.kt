package com.mediaproject.presentation.screen.admin.bag

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.AdminBagViewModel
import com.mediaproject.presentation.widgets.states.BagState

@Composable
fun AdminBagScreen(
    modifier: Modifier = Modifier,
    bagViewModel: AdminBagViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
) = Scaffold(
    topBar = {
        AdminBagScreenAppBar {
            onClickBack()
        }
    },
) { padding ->
    val uiState = bagViewModel.state.observeAsState()
    if (uiState.value is BagState.Success) {
        LaunchedEffect(true) {
            onClickBack()
        }
    }
    AdminBagScreenBody(
        modifier = modifier.padding(padding),
        onChangeCountryCode = bagViewModel::onChangeCountryCode,
        onChangeRegionCode = bagViewModel::onChangeRegionCode,
        onClickSave = bagViewModel::saveMarker
    )
}