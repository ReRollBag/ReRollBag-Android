package com.mediaproject.presentation.screen.admin.marker.returned

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.ReturnedMarkerViewModel
import com.mediaproject.presentation.widgets.states.ReturnedMarkerState

@Composable
fun ReturnedMarkerScreen(
    modifier: Modifier = Modifier,
    returnedMarkerViewModel: ReturnedMarkerViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
) = Scaffold(
    topBar = {
        ReturnedMarkerScreenAppBar {
            onClickBack()
        }
    },
) { padding ->
    val uiState = returnedMarkerViewModel.state.observeAsState()
    if (uiState.value is ReturnedMarkerState.Success) {
        LaunchedEffect(true) {
            onClickBack()
        }
    }
    ReturnedMarkerScreenBody(
        modifier = modifier.padding(padding),
        onChangeLatitude = returnedMarkerViewModel::onChangeLatitude,
        onChangeLongitude = returnedMarkerViewModel::onChangeLongitude,
        onChangeName = returnedMarkerViewModel::onChangeName,
        onClickSave = returnedMarkerViewModel::saveMarker
    )
}