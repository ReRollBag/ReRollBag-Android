package com.mediaproject.presentation.screen.vm

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.usecase.FindAllRentingMarkersUseCase
import com.mediaproject.domain.usecase.FindAllReturningMarkersUseCase
import com.mediaproject.domain.usecase.FindBagByIdUseCase
import com.mediaproject.presentation.widgets.states.AdminHomeUIState
import com.mediaproject.presentation.widgets.states.HomeUIState
import com.mediaproject.presentation.widgets.states.LocationState
import com.mediaproject.presentation.widgets.states.QrScanState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminMapViewModel
@Inject
constructor(
    private val findAllReturningMarkersUseCase: FindAllReturningMarkersUseCase,
    private val findBagByIdUseCase: FindBagByIdUseCase,
) : ViewModel() {

    private val _uiState = MutableLiveData<AdminHomeUIState>(AdminHomeUIState.Init)
    val uiState: LiveData<AdminHomeUIState>
        get() = _uiState

    fun updateLocation(location: Location) = _uiState.value?.let {
        _uiState.value = AdminHomeUIState.Update(
            qrScanState = it.qrScanState,
            locationState = LocationState.Update(updateData = location),
            markerList = it.markerList,
        )
    }

    fun updateCanceledQr() = _uiState.value?.let {
        _uiState.value = AdminHomeUIState.Update(
            qrScanState = QrScanState.Update(
                qrScanUrl = "",
                bagInfo = BagInfo(
                    bagsId = "-1"
                )
            ),
            locationState = it.locationState,
            markerList = it.markerList,
        )

    }

    fun updateQrScanUrl(url: String) = viewModelScope.launch {
        when (url.isNotEmpty()) {
            true -> try {
                when (url.startsWith("RRB")) {
                    true -> {
                        val list = url.split("_")
                        Log.d("ReRollBag", "Get BagId: ${"${list[1]}_${list[2]}_${list[3]}"}")
                        findBagById("${list[1]}_${list[2]}_${list[3]}")
                    }
                    false -> updateCanceledQr()
                }
            } catch (e: Exception) {
                updateCanceledQr()
            }
            false -> updateCanceledQr()
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
                AdminHomeUIState.Update(
                    qrScanState = QrScanState.Update(
                        qrScanUrl = it.qrScanState.qrScanUrl,
                        bagInfo = bagInfo
                    ),
                    locationState = it.locationState,
                    markerList = it.markerList,
                )
            )
        }
    }

    fun clearQrScan() = _uiState.value?.let {
        _uiState.value = AdminHomeUIState.Update(
            qrScanState = QrScanState.Init,
            locationState = it.locationState,
            markerList = it.markerList,
        )
    }

    fun updateIsRent(isRent: Boolean) = _uiState.value?.let {
        _uiState.value = AdminHomeUIState.Update(
            qrScanState = it.qrScanState,
            locationState = it.locationState,
            markerList = it.markerList,
        )
    }

    fun findAllReturningMarkers() = viewModelScope.launch {
        _uiState.value?.let {
            _uiState.value = AdminHomeUIState.Update(
                qrScanState = it.qrScanState,
                locationState = it.locationState,
                markerList = listOf(),
            )
        }
        findAllReturningMarkersUseCase().onSuccess { list ->
            _uiState.value?.let {
                _uiState.postValue(
                    AdminHomeUIState.Update(
                        qrScanState = it.qrScanState,
                        locationState = it.locationState,
                        markerList = list,
                    )
                )
            }
        }
    }

}