package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.mediaproject.domain.model.SignUpData
import com.mediaproject.domain.usecase.IsExistUserIdUseCase
import com.mediaproject.domain.usecase.SignUpUseCase
import com.mediaproject.presentation.screen.landing.signup.SignUpErrorConst
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
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {
    companion object {
        private const val TAG = "[SignUpVM]"
    }

    private val _signUpState = MutableLiveData<SignUpState>(SignUpState.SignUpInit)
    val signUpState: LiveData<SignUpState>
        get() = _signUpState

    private fun postLoading() = _signUpState.postValue(SignUpState.SignUpLoading(_signUpState.value!!.data))

    fun changeEmail(
        userId: String,
    ) = _signUpState.value!!.data.run {
        _signUpState.value = SignUpState.UpdateData(
            state = SignUpData(
                userId = userId,
                isExistUserId = this.isExistUserId,
                password = this.password,
                passwordCheckStr = this.passwordCheckStr,
                name = this.name
            )
        )
    }

    fun changePassword(
        password: String
    ) = _signUpState.value!!.data.run {
        _signUpState.value = SignUpState.UpdateData(
            state = SignUpData(
                userId = this.userId,
                isExistUserId = this.isExistUserId,
                password = password,
                passwordCheckStr = this.passwordCheckStr,
                name = this.name
            )
        )
    }

    fun changePasswordChecker(
        passwordChecker: String
    ) = _signUpState.value!!.data.run {
        _signUpState.value = SignUpState.UpdateData(
            state = SignUpData(
                userId = this.userId,
                isExistUserId = this.isExistUserId,
                password = this.password,
                passwordCheckStr = passwordChecker,
                name = this.name
            )
        )
    }

    fun changeName(
        name: String
    ) = _signUpState.value!!.data.run {
        _signUpState.value = SignUpState.UpdateData(
            state = SignUpData(
                userId = this.userId,
                isExistUserId = this.isExistUserId,
                password = this.password,
                passwordCheckStr = this.passwordCheckStr,
                name = name
            )
        )
    }

    fun signUp(
        data: SignUpData,
    ) = viewModelScope.launch {
        postLoading()
        data.run {
            when (isExistUserId) {
                true -> {
                    Log.d(TAG, "userId: $userId")
                    firebaseAuth.createUserWithEmailAndPassword(userId, password).addOnCompleteListener { task ->
                        when (task.isSuccessful) {
                            true -> {
//                                firebaseAuth.currentUser!!.getIdToken(false)
                                viewModelScope.launch {
                                    signUpUseCase(
                                        params = SignUpUseCase.Params(
                                            userId = userId,
                                            nickname = name,
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
                                                state = data,
                                                errorMessage = it.message ?: ""
                                            )
                                        )
                                    }
                                }
                            }
                            false -> {
                                Log.d(TAG,task.exception?.message ?: "aaaa")
                                _signUpState.postValue(
                                    SignUpState.SignUpError(
                                        state = data,
                                        errorMessage = SignUpErrorConst.UNKNOWN_ERROR
                                    )
                                )
                            }
                        }
                    }
                }
                false -> {
                    _signUpState.postValue(
                        SignUpState.SignUpError(
                            state = data,
                            errorMessage = SignUpErrorConst.DUPLICATE_EMAIL_CHECK_NOT_AVAILABLE
                        )
                    )
                }
            }
        }
    }

    fun duplicateCheckUserId(
        data: SignUpData
    ) = viewModelScope.launch {
        postLoading()
        isExistUserIdUseCase(
            params = IsExistUserIdUseCase.Params(
                userId = data.userId
            )
        ).onSuccess {
            Log.d(TAG, "Success")
            _signUpState.postValue(
                SignUpState.UpdateData(
                    state = SignUpData(
                        data,
                        isExistUserId = true,
                    ),
                )
            )
        }.onFailure {
            Log.d(TAG, it.message ?: "")
            _signUpState.postValue(
                SignUpState.SignUpError(
                    state = data,
                    errorMessage = SignUpErrorConst.DUPLICATE_EMAIL
                )
            )
        }
    }

    @Deprecated("UnUsed")
    private fun duplicateCheckNickname(
        data: SignUpData,
    ) = viewModelScope.launch {
        throw Exception("UnUsed")
//        postLoading()
//        isExistNicknameUseCase(
//            params = IsExistNicknameUseCase.Params(
//                nickname = data.name
//            )
//        ).onSuccess {
//            Log.d(TAG, "Success")
//            _signUpState.postValue(
//                SignUpState.DuplicateCheckSuccess(
//                    state = SignUpData(
//                        data,
//                        isExistUserId = data.isExistUserId,
//                        isExistNickname = true
//                    )
//                )
//            )
//        }.onFailure {
//            Log.d(TAG, it.message ?: "")
//            _signUpState.postValue(
//                SignUpState.SignUpError(
//                    state = data,
//                    errorMessage = "동일한 닉네임이 존재합니다."
//                )
//            )
//        }
    }

}