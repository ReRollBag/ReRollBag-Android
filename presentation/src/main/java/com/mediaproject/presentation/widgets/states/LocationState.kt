package com.mediaproject.presentation.widgets.states

import android.location.Location

sealed class LocationState(
    val location: Location
) {
    object Init : LocationState(location = Location(""))
    data class Update(
        private val updateData: Location
    ) : LocationState(location = updateData)
}
