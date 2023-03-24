package com.mediaproject.presentation.screen.vm

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.FindAllRentingMarkersUseCase
import com.mediaproject.domain.usecase.FindAllReturningMarkersUseCase
import com.mediaproject.domain.usecase.FindBagByIdUseCase
import com.mediaproject.presentation.widgets.states.HomeUIState
import com.mediaproject.presentation.widgets.states.LocationState
import com.mediaproject.presentation.widgets.states.QrScanState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel
@Inject
constructor(
    private val findAllRentingMarkersUseCase: FindAllRentingMarkersUseCase,
    private val findAllReturningMarkersUseCase: FindAllReturningMarkersUseCase,
    private val findBagByIdUseCase: FindBagByIdUseCase,
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

    fun updateQrScanUrl(url: String) = viewModelScope.launch {
        if (url.isNotEmpty()) {
            try {
                if (url.startsWith("RRB")) {
                    val list = url.split("_")
                    Log.d("ReRollBag", "Get BagId: ${"${list[1]}_${list[2]}_${list[3]}"}")
                    findBagById("${list[1]}_${list[2]}_${list[3]}")
                }
            } catch (e: Exception) {
                _uiState.value?.let {
                    _uiState.postValue(
                        HomeUIState.Update(
                            updateQrScan = QrScanState.Init,
                            updateLocation = it.locationState,
                            updateIsRent = it.isRentState,
                            updateMarkerList = it.markerList,
                        )
                    )
                }
            }
        }
    }

    private suspend fun findBagById(
        bagId: String
    ) = findBagByIdUseCase(
        params = FindBagByIdUseCase.Params(
            bagId = bagId
        )
    ).onSuccess { bagInfo ->
        _uiState.value?.let {
            _uiState.postValue(
                HomeUIState.Update(
                    updateQrScan = QrScanState.Update(
                        qrScanUrl = it.qrScanState.qrScanUrl,
                        bagInfo = bagInfo
                    ),
                    updateLocation = it.locationState,
                    updateIsRent = it.isRentState,
                    updateMarkerList = it.markerList,
                )
            )
        }
    }

    fun clearQrScan() = _uiState.value?.let {
        _uiState.value = HomeUIState.Update(
            updateQrScan = QrScanState.Init,
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