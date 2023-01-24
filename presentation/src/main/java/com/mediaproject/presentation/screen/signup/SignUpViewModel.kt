package com.mediaproject.presentation.screen.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mediaproject.domain.usecase.IsExistNicknameUseCase
import com.mediaproject.domain.usecase.IsExistUserIdUseCase
import com.mediaproject.domain.usecase.SignUpUseCase
import com.mediaproject.presentation.widgets.states.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject
constructor(
    private val signUpUseCase: SignUpUseCase,
    private val isExistUserIdUseCase: IsExistUserIdUseCase,
    private val isExistNicknameUseCase: IsExistNicknameUseCase,
) : ViewModel() {
    companion object {
        private const val TAG = "[SignUpVM]"
    }

    private val _signUpState = MutableLiveData<SignUpState>(SignUpState.SignUpInit)
    val signUpState: LiveData<SignUpState>
        get() = _signUpState

    fun signUp(
        userId: String,
        isExistUserId: Boolean,
        nickname: String,
        isExistNickname: Boolean,
        password: String,
        userRole: String = "",
    ) = viewModelScope.launch {
        _signUpState.postValue(SignUpState.SignUpLoading)
        if (isExistUserId && isExistNickname) {
            signUpUseCase(
                params = SignUpUseCase.Params(
                    userId = userId,
                    nickname = nickname,
                    password = password,
                    userRole = userRole,
                )
            ).onSuccess {
                Log.d(TAG, "Entry signUp method onSuccess")
                _signUpState.postValue(SignUpState.SignUpSuccess)
            }.onFailure {
                Log.d(TAG, "Entry signUp method onFailure")
                _signUpState.postValue(
                    SignUpState.SignUpError(
                        userId = userId,
                        isExistUserId = isExistUserId,
                        nickname = nickname,
                        isExistNickname = isExistNickname,
                        password = password,
                        userRole = userRole,
                        errorMessage = it.message ?: ""
                    )
                )
            }
        } else {
            when (isExistUserId) {
                true -> {
                    _signUpState.postValue(
                        SignUpState.SignUpError(
                            userId = userId,
                            isExistUserId = isExistUserId,
                            nickname = nickname,
                            isExistNickname = isExistNickname,
                            password = password,
                            userRole = userRole,
                            errorMessage = "닉네임 중복 검사를 해주세요."
                        )
                    )
                }
                false -> {
                    _signUpState.postValue(
                        SignUpState.SignUpError(
                            userId = userId,
                            isExistUserId = isExistUserId,
                            nickname = nickname,
                            isExistNickname = isExistNickname,
                            password = password,
                            userRole = userRole,
                            errorMessage = "아이디 중복 검사를 해주세요."
                        )
                    )
                }
            }

        }
    }

    fun duplicateCheckUserId(
        userId: String,
        isExistUserId: Boolean,
        nickname: String,
        isExistNickname: Boolean,
        password: String,
        userRole: String = "",
    ) = viewModelScope.launch {
        _signUpState.postValue(SignUpState.SignUpLoading)
        isExistUserIdUseCase(
            params = IsExistUserIdUseCase.Params(
                userId = userId
            )
        ).onSuccess {
            Log.d(TAG, "Success")
            _signUpState.postValue(
                SignUpState.DuplicateCheckSuccess(
                    userId = userId,
                    isExistUserId = true,
                    nickname = nickname,
                    isExistNickname = isExistNickname,
                    password = password,
                    userRole = userRole,
                )
            )
        }.onFailure {
            Log.d(TAG, it.message ?: "")
            _signUpState.postValue(
                SignUpState.SignUpError(
                    userId = userId,
                    isExistUserId = isExistUserId,
                    nickname = nickname,
                    isExistNickname = isExistNickname,
                    password = password,
                    userRole = userRole,
                    errorMessage = "동일한 아이디가 존재합니다."
                )
            )
        }
    }

    fun duplicateCheckNickname(
        userId: String,
        isExistUserId: Boolean,
        nickname: String,
        isExistNickname: Boolean,
        password: String,
        userRole: String = "",
    ) = viewModelScope.launch {
        _signUpState.postValue(SignUpState.SignUpLoading)
        isExistNicknameUseCase(
            params = IsExistNicknameUseCase.Params(
                nickname = nickname
            )
        ).onSuccess {
            Log.d(TAG, "Success")
            _signUpState.postValue(
                SignUpState.DuplicateCheckSuccess(
                    userId = userId,
                    isExistUserId = isExistUserId,
                    nickname = nickname,
                    isExistNickname = true,
                    password = password,
                    userRole = userRole,
                )
            )
        }.onFailure {
            Log.d(TAG, it.message ?: "")
            _signUpState.postValue(
                SignUpState.SignUpError(
                    userId = userId,
                    isExistUserId = isExistUserId,
                    nickname = nickname,
                    isExistNickname = isExistNickname,
                    password = password,
                    userRole = userRole,
                    errorMessage = "동일한 닉네임이 존재합니다."
                )
            )
        }
    }

}