package com.mediaproject.presentation.screen.vm

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.presentation.widgets.states.HomeUIState
import com.mediaproject.presentation.widgets.states.LocationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel
@Inject
constructor(

) : ViewModel() {

    private val _uiState = MutableLiveData<HomeUIState>(HomeUIState.Init)
    val uiState: LiveData<HomeUIState>
        get() = _uiState

    fun updateLocation(location: Location) = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = it.qrScanState,
            updateLocation = LocationState.Update(updateData = location),
            updateIsRent = it.isRentState
        )
    }

    fun updateQrScanUrl(url: String) = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = url,
            updateLocation = it.locationState,
            updateIsRent = it.isRentState
        )
    }

    fun updateIsRent(isRent: Boolean) = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = it.qrScanState,
            updateLocation = it.locationState,
            updateIsRent = isRent
        )
    }

    fun clearQrScan() = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = "",
            updateLocation = it.locationState,
            updateIsRent = it.isRentState
        )
    }

}