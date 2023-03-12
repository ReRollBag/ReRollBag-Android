package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.GetUserInfoUseCase
import com.mediaproject.domain.usecase.GetUserRentingBagsListUseCase
import com.mediaproject.presentation.widgets.states.HomeMenuState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMenuViewModel
@Inject
constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getUserRentingBagsListUseCase: GetUserRentingBagsListUseCase,
) : ViewModel() {
    companion object {
        private const val TAG = "[HMenuVM]"
    }

    private val _homeMenuState = MutableLiveData<HomeMenuState>(HomeMenuState.Init)
    val homeMenuState: LiveData<HomeMenuState>
        get() = _homeMenuState

    fun getUserInfo() = viewModelScope.launch {
        getUserInfoUseCase().onSuccess {
            Log.d(TAG, "Success Get User Info")

            _homeMenuState.postValue(
                HomeMenuState.Update(
                    updateUserId = it.userId,
                    updateUserName = it.userName,
                    updateListRentingBag = _homeMenuState.value?.listRentingBag ?: listOf()
                )
            )
        }
    }

    fun getUserRentingBagsList() = viewModelScope.launch {
        getUserRentingBagsListUseCase().onSuccess {
            Log.d("TAG", "Success getUserRentingBagsList")
            _homeMenuState.postValue(
                HomeMenuState.Update(
                    updateUserId = _homeMenuState.value?.userId ?: "",
                    updateUserName = _homeMenuState.value?.userName ?: "",
                    updateListRentingBag = it,
                )
            )
        }
    }

}