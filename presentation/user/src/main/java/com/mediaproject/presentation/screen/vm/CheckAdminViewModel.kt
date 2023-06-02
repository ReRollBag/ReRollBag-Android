package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mediaproject.domain.usecase.ApplyAdminUseCase
import com.mediaproject.domain.usecase.SetUpAdminUseCase
import com.mediaproject.presentation.widgets.states.CheckAdminState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckAdminViewModel
@Inject
constructor(
    private val applyAdminUseCase: ApplyAdminUseCase,
    private val setUpAdminUseCase: SetUpAdminUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<CheckAdminState>(CheckAdminState.Init)
    val state: LiveData<CheckAdminState>
        get() = _state

    fun applyAdmin() = CoroutineScope(Dispatchers.IO).launch {
        when (applyAdminUseCase()) {
            true -> _state.postValue(CheckAdminState.Issued)
            false -> {}
        }
    }

    fun setUpAdmin() {
        when (val value = _state.value) {
            is CheckAdminState.Update -> {
                CoroutineScope(Dispatchers.IO).launch {
                    setUpAdminUseCase(
                        params = SetUpAdminUseCase.Params(
                            region = value.region,
                            certification = value.certification
                        )
                    ).onSuccess {
                        _state.postValue(CheckAdminState.Success)
                    }
                }
            }
            else -> {}
        }
    }

    fun onChangeRegion(region: String) = when (val value = _state.value) {
        is CheckAdminState.Update -> _state.value = CheckAdminState.Update(
            region = region,
            certification = value.certification
        )
        else -> _state.value = CheckAdminState.Update(
            region = region,
            certification = 0
        )
    }

    fun onChangeCertification(certification: Int) = when (val value = _state.value) {
        is CheckAdminState.Update -> _state.value = CheckAdminState.Update(
            region = value.region,
            certification = certification
        )
        else -> _state.value = CheckAdminState.Update(
            region = "",
            certification = certification
        )
    }

}