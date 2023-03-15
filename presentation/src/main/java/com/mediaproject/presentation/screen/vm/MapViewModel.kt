package com.mediaproject.presentation.screen.vm

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.presentation.widgets.states.LocationState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel
@Inject
constructor(

) : ViewModel() {

    private val _locationState = MutableLiveData<LocationState>(LocationState.Init)
    val locationState: LiveData<LocationState>
        get() = _locationState

    private val _qrScanState = MutableLiveData("")
    val qrScanState: LiveData<String>
        get() = _qrScanState

    fun updateLocation(location: Location) {
        _locationState.value = LocationState.Update(updateData = location)
    }

    fun updateQrScanUrl(url: String) {
        _qrScanState.value = url
    }

    fun clearQrScan() {
        _qrScanState.value = ""
    }

}