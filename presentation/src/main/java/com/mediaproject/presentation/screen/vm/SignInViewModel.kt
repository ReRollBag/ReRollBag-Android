package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.SignInUseCase
import com.mediaproject.presentation.widgets.states.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {
    companion object {
        private const val TAG = "[SignInVM]"
    }

    private val _signInState = MutableLiveData<SignInState>(SignInState.SignInInit)
    val signInState: LiveData<SignInState>
        get() = _signInState

    fun signIn(
        userId: String,
        password: String,
    ) = viewModelScope.launch {
        _signInState.postValue(SignInState.SignInLoading)
        signInUseCase(
            params = SignInUseCase.Params(
                userId = userId,
                password = password,
            )
        ).onSuccess {
            Log.d(TAG, "Entry signIn method onSuccess")
            _signInState.postValue(SignInState.SignInSuccess)
        }.onFailure {
            Log.d(TAG, "Entry signIn method onFailure")
            _signInState.postValue(
                SignInState.SignInError(
                    userId = userId,
                    password = password,
                    errorMessage = it.message ?: ""
                )
            )
        }
    }

}