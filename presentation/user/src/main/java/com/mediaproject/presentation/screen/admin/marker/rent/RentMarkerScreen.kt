package com.mediaproject.presentation.screen.admin.marker.rent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.RentMarkerViewModel
import com.mediaproject.presentation.widgets.states.RentMarkerState

@Composable
fun RentMarkerScreen(
    modifier: Modifier = Modifier,
    rentMarkerViewModel: RentMarkerViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
) = Scaffold(
    topBar = {
        RentMarkerScreenAppBar {
            onClickBack()
        }
    },
) { padding ->
    val uiState = rentMarkerViewModel.state.observeAsState()
    if (uiState.value is RentMarkerState.Success) {
        LaunchedEffect(true) {
            onClickBack()
        }
    }
    RentMarkerScreenBody(
        modifier = modifier.padding(padding),
        onChangeLatitude = rentMarkerViewModel::onChangeLatitude,
        onChangeLongitude = rentMarkerViewModel::onChangeLongitude,
        onChangeName = rentMarkerViewModel::onChangeName,
        onChangeMaxBagsNumber = rentMarkerViewModel::onChangeMaxBagsNumber,
        onClickSave = rentMarkerViewModel::saveMarker
    )
}