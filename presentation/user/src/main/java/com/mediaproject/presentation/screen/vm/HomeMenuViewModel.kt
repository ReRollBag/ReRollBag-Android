package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.mediaproject.domain.usecase.GetUserInfoUseCase
import com.mediaproject.domain.usecase.GetUserRentingBagsListUseCase
import com.mediaproject.domain.usecase.ReIssueTokenUseCase
import com.mediaproject.domain.usecase.SignOutUseCase
import com.mediaproject.presentation.widgets.states.HomeMenuState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMenuViewModel
@Inject
constructor(
    private val reIssueTokenUseCase: ReIssueTokenUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getUserRentingBagsListUseCase: GetUserRentingBagsListUseCase,
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

        _homeMenuState.postValue(
            HomeMenuState.Update(
                updateUserId = it.userId,
                updateUserName = it.userName,
                updateListRentingBag = _homeMenuState.value?.listRentingBag ?: listOf()
            )
        )
    }

    fun getUserRentingBagsList() = viewModelScope.launch {
        sideEffectGetUserRentingBagsList().onFailure {
            when (it.message) {
                "ExpiredJwtException" -> {
                    reIssueTokenUseCase().onSuccess {
                        sideEffectGetUserRentingBagsList()
                    }
                }
            }
        }
    }

    private suspend fun sideEffectGetUserRentingBagsList() = getUserRentingBagsListUseCase().onSuccess {
        Log.d("TAG", "Success getUserRentingBagsList")
        _homeMenuState.postValue(
            HomeMenuState.Update(
                updateUserId = _homeMenuState.value?.userId ?: "",
                updateUserName = _homeMenuState.value?.userName ?: "",
                updateListRentingBag = it,
            )
        )
    }

    fun signOut() = viewModelScope.launch {
        signOutUseCase().onSuccess {
            firebaseAuth.signOut()
            _homeMenuState.postValue(HomeMenuState.SignOut)
        }
    }

}