package com.mediaproject.presentation.widgets.states

import com.mediaproject.core.model.ReRollBagMarker

sealed class HomeUIState(
    val qrScanState: QrScanState,
    val locationState: LocationState,
    val isRentState: Boolean,
    val markerList: List<com.mediaproject.core.model.ReRollBagMarker>,
) {

    object Init : HomeUIState(
        qrScanState = QrScanState.Init,
        locationState = LocationState.Init,
        isRentState = true,
        markerList = listOf()
    )

    data class Update(
        private val updateQrScan: QrScanState,
        private val updateLocation: LocationState,
        private val updateIsRent: Boolean,
        private val updateMarkerList: List<com.mediaproject.core.model.ReRollBagMarker>,
    ) : HomeUIState(
        qrScanState = updateQrScan,
        locationState = updateLocation,
        isRentState = updateIsRent,
        markerList = updateMarkerList,
    )

}
