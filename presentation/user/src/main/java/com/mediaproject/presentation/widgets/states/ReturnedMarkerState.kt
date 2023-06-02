package com.mediaproject.presentation.widgets.states

sealed class ReturnedMarkerState(
    open val latitude: Double,
    open val longitude: Double,
    open val name: String,
) {

    object Init : ReturnedMarkerState(
        latitude = 0.0,
        longitude = 0.0,
        name = "",
    )

    data class Update(
        override val latitude: Double,
        override val longitude: Double,
        override val name: String,
    ) : ReturnedMarkerState(
        latitude = latitude,
        longitude = longitude,
        name = name,
    )

    object Success : ReturnedMarkerState(
        latitude = 0.0,
        longitude = 0.0,
        name = "",
    )

}