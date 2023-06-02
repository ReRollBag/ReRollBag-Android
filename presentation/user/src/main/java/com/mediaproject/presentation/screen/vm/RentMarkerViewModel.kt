package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.domain.usecase.SaveRentingMarkerUseCase
import com.mediaproject.presentation.widgets.states.RentMarkerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RentMarkerViewModel
@Inject
constructor(
    private val saveRentingMarkerUseCase: SaveRentingMarkerUseCase
) : ViewModel() {

    private val _state = MutableLiveData<RentMarkerState>(RentMarkerState.Init)
    val state: LiveData<RentMarkerState>
        get() = _state

    fun saveMarker() {
        when (val value = _state.value) {
            is RentMarkerState.Update -> CoroutineScope(Dispatchers.IO).launch {
                saveRentingMarkerUseCase(
                    params = SaveRentingMarkerUseCase.Params(
                        latitude = value.latitude,
                        longitude = value.longitude,
                        name = value.name,
                        maxBagsNum = value.maxBagsNumber,
                    )
                ).onSuccess {
                    _state.postValue(RentMarkerState.Success)
                }
            }
            else -> {}
        }
    }

    fun onChangeLatitude(latitude: Double) {
        when (val value = _state.value) {
            is RentMarkerState.Update -> _state.value = RentMarkerState.Update(
                latitude = latitude,
                longitude = value.longitude,
                name = value.name,
                maxBagsNumber = value.maxBagsNumber
            )
            else -> _state.value = RentMarkerState.Update(
                latitude = latitude,
                longitude = 0.0,
                name = "",
                maxBagsNumber = 0
            )
        }
    }

    fun onChangeLongitude(longitude: Double) {
        when (val value = _state.value) {
            is RentMarkerState.Update -> _state.value = RentMarkerState.Update(
                latitude = value.latitude,
                longitude = longitude,
                name = value.name,
                maxBagsNumber = value.maxBagsNumber
            )
            else -> _state.value = RentMarkerState.Update(
                latitude = 0.0,
                longitude = longitude,
                name = "",
                maxBagsNumber = 0
            )
        }
    }

    fun onChangeName(name: String) {
        when (val value = _state.value) {
            is RentMarkerState.Update -> _state.value = RentMarkerState.Update(
                latitude = value.latitude,
                longitude = value.longitude,
                name = name,
                maxBagsNumber = value.maxBagsNumber
            )
            else -> _state.value = RentMarkerState.Update(
                latitude = 0.0,
                longitude = 0.0,
                name = name,
                maxBagsNumber = 0
            )
        }
    }

    fun onChangeMaxBagsNumber(maxBagsNumber: Int) {
        when (val value = _state.value) {
            is RentMarkerState.Update -> _state.value = RentMarkerState.Update(
                latitude = value.latitude,
                longitude = value.longitude,
                name = value.name,
                maxBagsNumber = maxBagsNumber
            )
            else -> _state.value = RentMarkerState.Update(
                latitude = 0.0,
                longitude = 0.0,
                name = "",
                maxBagsNumber = maxBagsNumber
            )
        }
    }

}