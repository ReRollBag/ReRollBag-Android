package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.mediaproject.core.model.SignUpData
import com.mediaproject.domain.usecase.IsExistUserIdUseCase
import com.mediaproject.domain.usecase.SignUpUseCase
import com.mediaproject.presentation.widgets.utils.error.SignUpErrorConst
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
            state = com.mediaproject.core.model.SignUpData(
                userId = userId,
                isCheckDuplication = this.isCheckDuplication,
                isErrorDuplication = this.isErrorDuplication,
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
            state = com.mediaproject.core.model.SignUpData(
                userId = this.userId,
                isCheckDuplication = this.isCheckDuplication,
                isErrorDuplication = this.isErrorDuplication,
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
            state = com.mediaproject.core.model.SignUpData(
                userId = this.userId,
                isCheckDuplication = this.isCheckDuplication,
                isErrorDuplication = this.isErrorDuplication,
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
            state = com.mediaproject.core.model.SignUpData(
                userId = this.userId,
                isCheckDuplication = this.isCheckDuplication,
                isErrorDuplication = this.isErrorDuplication,
                password = this.password,
                passwordCheckStr = this.passwordCheckStr,
                name = name
            )
        )
    }

    fun signUp(
        data: com.mediaproject.core.model.SignUpData,
    ) = viewModelScope.launch {
        postLoading()
        data.run {
            when (isCheckDuplication) {
                true -> {
                    Log.d(TAG, "userId: $userId")
                    firebaseAuth.createUserWithEmailAndPassword(userId, password).addOnCompleteListener { task ->
                        when (task.isSuccessful) {
                            true -> {
                                firebaseAuth.currentUser!!.getIdToken(true)
                                    .addOnCompleteListener {
                                        signUpWithIdToken(data = data, idToken = it.result.token ?: "")
                                    }
                                    .addOnCanceledListener {
                                        _signUpState.postValue(
                                            SignUpState.SignUpError(
                                                state = data,
                                                errorMessage = SignUpErrorConst.UNKNOWN_ERROR
                                            )
                                        )
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

    private fun signUpWithIdToken(
        data: com.mediaproject.core.model.SignUpData,
        idToken: String,
    ) = viewModelScope.launch {
        signUpUseCase(
            params = SignUpUseCase.Params(
                userId = data.userId,
                name = data.name,
                idToken = idToken,
                userRole = data.userRole,
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

    fun duplicateCheckUserId(
        data: com.mediaproject.core.model.SignUpData
    ) = viewModelScope.launch {
        postLoading()
        when (data.userId.isEmpty()) {
            true -> _signUpState.postValue(SignUpState.UpdateData(state = data))
            false -> {
                isExistUserIdUseCase(
                    params = IsExistUserIdUseCase.Params(
                        userId = data.userId
                    )
                ).onSuccess {
                    Log.d(TAG, "Success")
                    _signUpState.postValue(
                        SignUpState.UpdateData(
                            state = com.mediaproject.core.model.SignUpData(
                                data,
                                isExistUserId = true,
                                isErrorDuplication = false
                            ),
                        )
                    )
                }.onFailure {
                    Log.d(TAG, it.message ?: "")
                    _signUpState.postValue(
                        SignUpState.SignUpError(
                            state = com.mediaproject.core.model.SignUpData(
                                data,
                                isExistUserId = false,
                                isErrorDuplication = true
                            ),
                            errorMessage = SignUpErrorConst.DUPLICATE_EMAIL
                        )
                    )
                }
            }
        }
    }

    fun refreshCheck(
        data: com.mediaproject.core.model.SignUpData
    ) = viewModelScope.launch {
        postLoading()
        _signUpState.postValue(
            SignUpState.UpdateData(
                state = data
            )
        )
    }

    @Deprecated("UnUsed")
    private fun duplicateCheckNickname(
        data: com.mediaproject.core.model.SignUpData,
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