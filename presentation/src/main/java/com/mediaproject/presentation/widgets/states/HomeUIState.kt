package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.ReRollBagMarker

sealed class HomeUIState(
    val qrScanState: String,
    val locationState: LocationState,
    val isRentState: Boolean,
    val markerList: List<ReRollBagMarker>,
) {

    object Init : HomeUIState(
        qrScanState = "",
        locationState = LocationState.Init,
        isRentState = true,
        markerList = listOf()
    )

    data class Update(
        private val updateQrScan: String,
        private val updateLocation: LocationState,
        private val updateIsRent: Boolean,
        private val updateMarkerList: List<ReRollBagMarker>,
    ) : HomeUIState(
        qrScanState = updateQrScan,
        locationState = updateLocation,
        isRentState = updateIsRent,
        markerList = updateMarkerList,
    )

}
