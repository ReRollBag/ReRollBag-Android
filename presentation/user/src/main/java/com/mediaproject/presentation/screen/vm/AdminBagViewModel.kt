package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.domain.usecase.SaveBagUseCase
import com.mediaproject.domain.usecase.SaveRentingMarkerUseCase
import com.mediaproject.domain.usecase.SaveReturningMarkerUseCase
import com.mediaproject.presentation.widgets.states.BagState
import com.mediaproject.presentation.widgets.states.RentMarkerState
import com.mediaproject.presentation.widgets.states.ReturnedMarkerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminBagViewModel
@Inject
constructor(
    private val saveBagUseCase: SaveBagUseCase
) : ViewModel() {

    private val _state = MutableLiveData<BagState>(BagState.Init)
    val state: LiveData<BagState>
        get() = _state

    fun saveMarker() {
        when (val value = _state.value) {
            is BagState.Update -> CoroutineScope(Dispatchers.IO).launch {
                saveBagUseCase(
                    params = SaveBagUseCase.Params(
                        countryCode = value.countryCode,
                        regionCode = value.regionCode
                    )
                ).onSuccess {
                    _state.postValue(BagState.Success)
                }
            }
            else -> {}
        }
    }

    fun onChangeCountryCode(countryCode: String) {
        when (val value = _state.value) {
            is BagState.Update -> _state.value = BagState.Update(
                countryCode = countryCode,
                regionCode = value.regionCode
            )
            else -> _state.value = BagState.Update(
                countryCode = countryCode,
                regionCode = ""
            )
        }
    }

    fun onChangeRegionCode(regionCode: String) {
        when (val value = _state.value) {
            is BagState.Update -> _state.value = BagState.Update(
                countryCode = value.countryCode,
                regionCode = regionCode
            )
            else -> _state.value = BagState.Update(
                countryCode = "",
                regionCode = regionCode
            )
        }
    }

}