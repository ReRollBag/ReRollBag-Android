package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.mediaproject.domain.usecase.IsAdminUserUseCase
import com.mediaproject.domain.usecase.IsAlreadyLoginUseCase
import com.mediaproject.domain.usecase.SignInUseCase
import com.mediaproject.domain.usecase.SignUpUseCase
import com.mediaproject.presentation.widgets.states.SignInState
import com.mediaproject.presentation.widgets.utils.error.SignInErrorConst
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    private val signInUseCase: SignInUseCase,
    private val isAdminUserUseCase: IsAdminUserUseCase,
    private val isAlreadyLoginUseCase: IsAlreadyLoginUseCase,
    private val firebaseAuth: FirebaseAuth,
) : ViewModel() {
    companion object {
        private const val TAG = "[SignInVM]"
    }

    private val _alreadyLogin = MutableLiveData<Boolean>()
    val alreadyLogin: LiveData<Boolean>
        get() = _alreadyLogin

    private val _adminLogin = MutableLiveData(false)
    val adminLogin: LiveData<Boolean>
        get() = _adminLogin

    private val _signInState = MutableLiveData<SignInState>(SignInState.SignInInit)
    val signInState: LiveData<SignInState>
        get() = _signInState

    fun isAlreadyLogin() = viewModelScope.launch {
        isAlreadyLoginUseCase()
            .onSuccess {
                when (isAdminUserUseCase()) {
                    true -> {
                        _adminLogin.postValue(true)
                        _alreadyLogin.postValue(true)
                    }
                    false -> {
                        _adminLogin.postValue(false)
                        _alreadyLogin.postValue(true)
                    }
                }
            }.onFailure {
                _adminLogin.postValue(false)
                _alreadyLogin.postValue(false)
            }
    }
    fun signIn(
        userId: String,
        password: String,
    ) = viewModelScope.launch {
        _signInState.postValue(SignInState.SignInLoading)
        try {
            firebaseAuth.signInWithEmailAndPassword(userId, password).addOnCompleteListener { task ->
                when (task.isSuccessful) {
                    true -> {
                        firebaseAuth.currentUser!!.getIdToken(true)
                            .addOnCompleteListener {
                                signInWithIdToken(idToken = it.result.token ?: "")
                            }
                            .addOnCanceledListener {
                                _signInState.postValue(
                                    SignInState.SignInError(
                                        userId = userId,
                                        password = password,
                                        errorMessage = task.exception?.message ?: ""
                                    )
                                )
                            }
                    }
                    false -> {
                        when (task.exception) {
                            is FirebaseAuthInvalidUserException -> _signInState.postValue(
                                SignInState.SignInError(
                                    userId = userId,
                                    password = password,
                                    errorMessage = SignInErrorConst.INVALID_USER_EXCEPTION
                                )
                            )
                            is FirebaseAuthInvalidCredentialsException -> _signInState.postValue(
                                SignInState.SignInError(
                                    userId = userId,
                                    password = password,
                                    errorMessage = SignInErrorConst.INVALID_USER_EXCEPTION
                                )
                            )
                            else -> {
                                Log.d("TAG", task.exception?.javaClass.toString())
                                _signInState.postValue(
                                    SignInState.SignInError(
                                        userId = userId,
                                        password = password,
                                        errorMessage = ""
                                    )
                                )
                            }
                        }

                    }
                }
            }
        } catch (e: IllegalArgumentException) {
            _signInState.postValue(
                SignInState.SignInError(
                    userId = userId,
                    password = password,
                    errorMessage = SignInErrorConst.NULL_OR_EMPTY_INPUT_EXCEPTION
                )
            )
        }

    }

    fun signIn(
        token: String
    ) = signInWithIdToken(idToken = token)

    fun signIn(
        credential: AuthCredential
    ) = viewModelScope.launch {
        _signInState.postValue(SignInState.SignInLoading)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            when (task.isSuccessful) {
                true -> {
                    try {
                        task.result.user!!.getIdToken(true).addOnCompleteListener {
                            signInWithIdToken(it.result.token!!)
                        }.addOnCanceledListener {
                            throwError(task.exception ?: Exception())
                        }
                    } catch (e: Exception) {
                        throwError(task.exception ?: Exception())
                    }
                }
                false -> throwError(task.exception ?: Exception())
            }
        }
    }

    fun throwError(
        error: Throwable
    ) = _signInState.postValue(
        SignInState.SignInError(
            userId = "",
            password = "",
            errorMessage = error.message ?: "",
        )
    )

    private fun signInWithIdToken(
        idToken: String
    ) = viewModelScope.launch {
        _signInState.postValue(SignInState.SignInSuccess(isAdmin = isAdminUserUseCase()))
//        signInUseCase(
//            params = SignInUseCase.Params(
//                idToken = idToken
//            )
//        ).onSuccess {
//            Log.d(TAG, "Entry signIn method onSuccess")
//            _signInState.postValue(SignInState.SignInSuccess(isAdmin = isAdminUserUseCase()))
//        }.onFailure {
//            Log.d(TAG, "Entry signIn method onFailure")
//            _signInState.postValue(
//                SignInState.SignInError(
//                    userId = "",
//                    password = "",
//                    errorMessage = it.message ?: ""
//                )
//            )
//        }
    }

}