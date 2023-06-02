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
import com.mediaproject.presentation.widgets.states.HomeMenuState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeMenuViewModel
@Inject
constructor(
    private val reIssueTokenUseCase: ReIssueTokenUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getUserRentingBagsListUseCase: GetUserRentingBagsListUseCase,
    private val getUserReturningBagsListUseCase: GetUserReturningBagsListUseCase,
    private val getUserReturnedBagsListUseCase: GetUserReturnedBagsListUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val firebaseAuth: FirebaseAuth,
) : ViewModel() {
    companion object {
        private const val TAG = "[HMenuVM]"
    }

    private val _homeMenuState = MutableLiveData<HomeMenuState>(HomeMenuState.Init)
    val homeMenuState: LiveData<HomeMenuState>
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
                HomeMenuState.Update(
                    userId = it.userId,
                    userName = it.userName,
                    listRentingBag = value.listRentingBag,
                    listReturningBag = value.listReturningBag,
                    listReturnedBag = value.listReturnedBag
                )
            )
        }

    }

    fun getUserBagsList() = CoroutineScope(Dispatchers.IO).launch {
        sideEffectGetUserRentingBagsList().onFailure {
            when (it.message) {
                "ExpiredJwtException" -> {
                    reIssueTokenUseCase().onSuccess {
                        sideEffectGetUserRentingBagsList()
                    }
                }
            }
        }
        sideEffectGetUserReturningBagsList().onFailure {
            when (it.message) {
                "ExpiredJwtException" -> {
                    reIssueTokenUseCase().onSuccess {
                        sideEffectGetUserReturningBagsList()
                    }
                }
            }
        }
        sideEffectGetUserReturnedBagsList().onFailure {
            when (it.message) {
                "ExpiredJwtException" -> {
                    reIssueTokenUseCase().onSuccess {
                        sideEffectGetUserReturnedBagsList()
                    }
                }
            }
        }
    }

    private suspend fun sideEffectGetUserRentingBagsList() = getUserRentingBagsListUseCase().onSuccess {
        _homeMenuState.value?.let { value ->
            _homeMenuState.postValue(
                HomeMenuState.Update(
                    userId = value.userId,
                    userName = value.userName,
                    listRentingBag = it,
                    listReturningBag = value.listReturningBag,
                    listReturnedBag = value.listReturnedBag
                )
            )
        }
    }

    private suspend fun sideEffectGetUserReturningBagsList() = getUserReturningBagsListUseCase().onSuccess {
        _homeMenuState.value?.let { value ->
            _homeMenuState.postValue(
                HomeMenuState.Update(
                    userId = value.userId,
                    userName = value.userName,
                    listRentingBag = value.listRentingBag,
                    listReturningBag = it,
                    listReturnedBag = value.listReturnedBag
                )
            )
        }
    }

    private suspend fun sideEffectGetUserReturnedBagsList() = getUserReturnedBagsListUseCase().onSuccess {
        _homeMenuState.value?.let { value ->
            _homeMenuState.postValue(
                HomeMenuState.Update(
                    userId = value.userId,
                    userName = value.userName,
                    listRentingBag = value.listRentingBag,
                    listReturningBag = value.listReturningBag,
                    listReturnedBag = it
                )
            )
        }
    }

    fun signOut() = viewModelScope.launch {
        signOutUseCase().onSuccess {
            firebaseAuth.signOut()
            _homeMenuState.postValue(HomeMenuState.SignOut)
        }
    }

}