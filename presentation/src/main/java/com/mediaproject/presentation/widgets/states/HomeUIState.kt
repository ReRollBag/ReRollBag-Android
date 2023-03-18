package com.mediaproject.presentation.widgets.states

sealed class HomeUIState(
    val qrScanState: String,
    val locationState: LocationState,
    val isRentState: Boolean
) {

    object Init : HomeUIState(
        qrScanState = "",
        locationState = LocationState.Init,
        isRentState = true,
    )

    data class Update(
        private val updateQrScan: String,
        private val updateLocation: LocationState,
        private val updateIsRent: Boolean
    ) : HomeUIState(
        qrScanState = updateQrScan,
        locationState = updateLocation,
        isRentState = updateIsRent,
    )

}
