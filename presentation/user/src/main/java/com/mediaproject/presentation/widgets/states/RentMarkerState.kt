package com.mediaproject.presentation.widgets.states

sealed class RentMarkerState(
    open val latitude: Double,
    open val longitude: Double,
    open val name: String,
    open val maxBagsNumber: Int
) {

    object Init : RentMarkerState(
        latitude = 0.0,
        longitude = 0.0,
        name = "",
        maxBagsNumber = 0
    )

    data class Update(
        override val latitude: Double,
        override val longitude: Double,
        override val name: String,
        override val maxBagsNumber: Int
    ) : RentMarkerState(
        latitude = latitude,
        longitude = longitude,
        name = name,
        maxBagsNumber = maxBagsNumber
    )

    object Success : RentMarkerState(
        latitude = 0.0,
        longitude = 0.0,
        name = "",
        maxBagsNumber = 0
    )

}