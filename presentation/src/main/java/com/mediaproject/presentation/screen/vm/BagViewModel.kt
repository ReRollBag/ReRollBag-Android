package com.mediaproject.presentation.screen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.GetUserInfoUseCase
import com.mediaproject.domain.usecase.RentBagUseCase
import com.mediaproject.domain.usecase.RequestReturningBagUseCase
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
) : ViewModel() {

    fun requestReturningBagWithBagId(
        bagId: String
    ) = viewModelScope.launch {
        getUserInfoUseCase().onSuccess { user ->
            requestReturningBagUseCase(
                params = RequestReturningBagUseCase.Params(
                    userId = user.userId,
                    bagId = bagId
                )
            )
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
            )
        }
    }

}