package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.domain.usecase.SaveRentingMarkerUseCase
import com.mediaproject.domain.usecase.SaveReturningMarkerUseCase
import com.mediaproject.presentation.widgets.states.RentMarkerState
import com.mediaproject.presentation.widgets.states.ReturnedMarkerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReturnedMarkerViewModel
@Inject
constructor(
    private val saveReturningMarkerUseCase: SaveReturningMarkerUseCase
) : ViewModel() {

    private val _state = MutableLiveData<ReturnedMarkerState>(ReturnedMarkerState.Init)
    val state: LiveData<ReturnedMarkerState>
        get() = _state

    fun saveMarker() {
        when (val value = _state.value) {
            is ReturnedMarkerState.Update -> CoroutineScope(Dispatchers.IO).launch {
                saveReturningMarkerUseCase(
                    params = SaveReturningMarkerUseCase.Params(
                        latitude = value.latitude,
                        longitude = value.longitude,
                        name = value.name,
                    )
                ).onSuccess {
                    _state.postValue(ReturnedMarkerState.Success)
                }
            }
            else -> {}
        }
    }

    fun onChangeLatitude(latitude: Double) {
        when (val value = _state.value) {
            is ReturnedMarkerState.Update -> _state.value = ReturnedMarkerState.Update(
                latitude = latitude,
                longitude = value.longitude,
                name = value.name,
            )
            else -> _state.value = ReturnedMarkerState.Update(
                latitude = latitude,
                longitude = 0.0,
                name = "",
            )
        }
    }

    fun onChangeLongitude(longitude: Double) {
        when (val value = _state.value) {
            is ReturnedMarkerState.Update -> _state.value = ReturnedMarkerState.Update(
                latitude = value.latitude,
                longitude = longitude,
                name = value.name,
            )
            else -> _state.value = ReturnedMarkerState.Update(
                latitude = 0.0,
                longitude = longitude,
                name = "",
            )
        }
    }

    fun onChangeName(name: String) {
        when (val value = _state.value) {
            is ReturnedMarkerState.Update -> _state.value = ReturnedMarkerState.Update(
                latitude = value.latitude,
                longitude = value.longitude,
                name = name,
            )
            else -> _state.value = ReturnedMarkerState.Update(
                latitude = 0.0,
                longitude = 0.0,
                name = name,
            )
        }
    }

}