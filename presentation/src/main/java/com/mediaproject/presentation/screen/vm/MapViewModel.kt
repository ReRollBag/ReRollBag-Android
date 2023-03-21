package com.mediaproject.presentation.screen.vm

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.FindAllRentingMarkersUseCase
import com.mediaproject.domain.usecase.FindAllReturningMarkersUseCase
import com.mediaproject.presentation.widgets.states.HomeUIState
import com.mediaproject.presentation.widgets.states.LocationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel
@Inject
constructor(
    private val findAllRentingMarkersUseCase: FindAllRentingMarkersUseCase,
    private val findAllReturningMarkersUseCase: FindAllReturningMarkersUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<HomeUIState>(HomeUIState.Init)
    val uiState: LiveData<HomeUIState>
        get() = _uiState

    fun updateLocation(location: Location) = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = it.qrScanState,
            updateLocation = LocationState.Update(updateData = location),
            updateIsRent = it.isRentState,
            updateMarkerList = it.markerList,
        )
    }

    fun updateQrScanUrl(url: String) = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = url,
            updateLocation = it.locationState,
            updateIsRent = it.isRentState,
            updateMarkerList = it.markerList,
        )
    }

    fun updateIsRent(isRent: Boolean) = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = it.qrScanState,
            updateLocation = it.locationState,
            updateIsRent = isRent,
            updateMarkerList = it.markerList,
        )
    }

    fun clearQrScan() = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = "",
            updateLocation = it.locationState,
            updateIsRent = it.isRentState,
            updateMarkerList = it.markerList,
        )
    }

    fun findAllRentingMarkers() = viewModelScope.launch {
        _uiState.value?.let {
            _uiState.value = HomeUIState.Update(
                updateQrScan = it.qrScanState,
                updateLocation = it.locationState,
                updateIsRent = it.isRentState,
                updateMarkerList = listOf(),
            )
        }
        findAllRentingMarkersUseCase().onSuccess { list ->
            _uiState.value?.let {
                _uiState.postValue(
                    HomeUIState.Update(
                        updateQrScan = it.qrScanState,
                        updateLocation = it.locationState,
                        updateIsRent = it.isRentState,
                        updateMarkerList = list,
                    )
                )
            }
        }
    }

    fun findAllReturningMarkers() = viewModelScope.launch {
        _uiState.value?.let {
            _uiState.value = HomeUIState.Update(
                updateQrScan = it.qrScanState,
                updateLocation = it.locationState,
                updateIsRent = it.isRentState,
                updateMarkerList = listOf(),
            )
        }
        findAllReturningMarkersUseCase().onSuccess { list ->
            _uiState.value?.let {
                _uiState.postValue(
                    HomeUIState.Update(
                        updateQrScan = it.qrScanState,
                        updateLocation = it.locationState,
                        updateIsRent = it.isRentState,
                        updateMarkerList = list,
                    )
                )
            }
        }
    }

}