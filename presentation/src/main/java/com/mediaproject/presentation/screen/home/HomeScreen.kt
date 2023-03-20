package com.mediaproject.presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.BagViewModel
import com.mediaproject.presentation.screen.vm.MapViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mapViewModel: MapViewModel = hiltViewModel(),
    bagViewModel: BagViewModel = hiltViewModel(),
    onClickQrScan: () -> Unit = {},
    onClickMenu: () -> Unit = {},
) = Scaffold(
    topBar = {
        HomeScreenAppBar {
            onClickMenu()
        }
    },
) { padding ->
    val uiState = mapViewModel.uiState.observeAsState()

    uiState.value?.let {
        HomeScreenBody(
            modifier = modifier.padding(padding),
            locationState = it.locationState,
            qrScanState = it.qrScanState,
            markerList = it.markerList,
            isRent = it.isRentState,
            onChangeRent = { value ->
                mapViewModel.updateIsRent(isRent = value)
            },
            onClickRentBag = { value ->
                bagViewModel.rentBagWithBagId(bagId = value)
                mapViewModel.clearQrScan()
            },
            onClickRequestRenting = { value ->
                bagViewModel.requestReturningBagWithBagId(bagId = value)
            },
            onRefreshRentingMarker = {
                mapViewModel.findAllRentingMarkers()
            },
            onRefreshReturningMarker = {
                mapViewModel.findAllReturningMarkers()
            },
            clearQrScanState = {
                mapViewModel.clearQrScan()
            }
        ) {
            onClickQrScan()
        }
    }
}