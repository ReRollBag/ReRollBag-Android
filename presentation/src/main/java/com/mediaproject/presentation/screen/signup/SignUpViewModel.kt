package com.mediaproject.presentation.screen.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.SignUpUseCase
import com.mediaproject.presentation.widgets.states.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject
constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    companion object {
        private const val TAG = "[SignUpVM]"
    }

    private val _signUpState = MutableLiveData<SignUpState>(SignUpState.SignUpInit)
    val signUpState: LiveData<SignUpState>
        get() = _signUpState

    fun signUp(
        userId: String,
        nickname: String,
        password: String
    ) = viewModelScope.launch {
        signUpUseCase(
            params = SignUpUseCase.Params(
                userId = userId,
                nickname = nickname,
                password = password
            )
        ).onSuccess {
            Log.d(TAG, "Entry signUp method onSuccess")
            _signUpState.postValue(SignUpState.SignUpSuccess)
        }.onFailure {
            Log.d(TAG, "Entry signUp method onFailure")
            _signUpState.postValue(
                SignUpState.SignUpError(
                    userId = userId,
                    nickname = nickname,
                    password = password,
                    errorMessage = it.message ?: ""
                )
            )
        }
    }

}