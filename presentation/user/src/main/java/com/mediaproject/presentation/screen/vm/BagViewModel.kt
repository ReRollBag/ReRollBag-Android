package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.core.model.BagInfo
import com.mediaproject.domain.usecase.FindBagByIdUseCase
import com.mediaproject.domain.usecase.GetUserInfoUseCase
import com.mediaproject.domain.usecase.RentBagUseCase
import com.mediaproject.domain.usecase.RequestReturningBagUseCase
import com.mediaproject.domain.usecase.ReturningBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BagViewModel
@Inject
constructor(
    private val requestReturningBagUseCase: RequestReturningBagUseCase,
    private val rentBagUseCase: RentBagUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val findBagByIdUseCase: FindBagByIdUseCase,
    private val returningBagUseCase: ReturningBagUseCase
) : ViewModel() {

    private val _selectedBagInfo = MutableLiveData<com.mediaproject.core.model.BagInfo>()
    val selectedBagInfo: LiveData<com.mediaproject.core.model.BagInfo>
        get() = _selectedBagInfo

    private val _hasSuccess = MutableLiveData("")
    val hasSuccess: LiveData<String>
        get() = _hasSuccess

    fun requestReturningBagWithBagId(
        bagId: String
    ) = viewModelScope.launch {
        getUserInfoUseCase().onSuccess { user ->
            requestReturningBagUseCase(
                params = RequestReturningBagUseCase.Params(
                    userId = user.userId,
                    bagId = bagId
                )
            ).onSuccess {
                _hasSuccess.postValue("return")
            }
        }
    }

    fun rentBagWithBagId(
        bagId: String
    ) = viewModelScope.launch {
        getUserInfoUseCase().onSuccess { user ->
            rentBagUseCase(
                params = RentBagUseCase.Params(
                    userId = user.userId,
                    bagId = bagId
                )
            ).onSuccess {
                _hasSuccess.postValue("rent")
            }
        }
    }

    fun findBagById(
        bagId: String
    ) = viewModelScope.launch {
        findBagByIdUseCase(
            params = FindBagByIdUseCase.Params(
                bagId = bagId
            )
        ).onSuccess { bagInfo ->
            _selectedBagInfo.postValue(bagInfo)
        }
    }

    fun requestReturnedBagWithBagId(
        bagId: String
    ) = viewModelScope.launch {
        returningBagUseCase(bagId = bagId).onSuccess {
            _hasSuccess.postValue("return")
        }
    }

}