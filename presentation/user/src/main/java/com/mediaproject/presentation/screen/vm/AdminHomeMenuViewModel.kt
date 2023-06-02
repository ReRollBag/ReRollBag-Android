package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.mediaproject.domain.usecase.GetUserInfoUseCase
import com.mediaproject.domain.usecase.GetUserRentingBagsListUseCase
import com.mediaproject.domain.usecase.GetUserReturnedBagsListUseCase
import com.mediaproject.domain.usecase.GetUserReturningBagsListUseCase
import com.mediaproject.domain.usecase.ReIssueTokenUseCase
import com.mediaproject.domain.usecase.SignOutUseCase
import com.mediaproject.presentation.widgets.states.AdminHomeMenuState
import com.mediaproject.presentation.widgets.states.HomeMenuState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminHomeMenuViewModel
@Inject
constructor(
    private val reIssueTokenUseCase: ReIssueTokenUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val firebaseAuth: FirebaseAuth,
) : ViewModel() {
    companion object {
        private const val TAG = "[AHMenuVM]"
    }

    private val _homeMenuState = MutableLiveData<AdminHomeMenuState>(AdminHomeMenuState.Init)
    val homeMenuState: LiveData<AdminHomeMenuState>
        get() = _homeMenuState

    fun getUserInfo() = viewModelScope.launch {
        sideEffectGetUserInfo().onFailure {
            when (it.message) {
                "ExpiredJwtException" -> {
                    reIssueTokenUseCase().onSuccess {
                        sideEffectGetUserInfo()
                    }
                }
            }
        }
    }

    private suspend fun sideEffectGetUserInfo() = getUserInfoUseCase().onSuccess {
        Log.d(TAG, "Success Get User Info")

        _homeMenuState.value?.let { value ->
            _homeMenuState.postValue(
                AdminHomeMenuState.Update(
                    userId = it.userId,
                    userName = it.userName,
                )
            )
        }

    }

    fun signOut() = viewModelScope.launch {
        signOutUseCase().onSuccess {
            firebaseAuth.signOut()
            _homeMenuState.postValue(AdminHomeMenuState.SignOut)
        }
    }

}