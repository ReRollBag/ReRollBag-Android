package com.mediaproject.presentation.screen.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.mediaproject.domain.usecase.SignInUseCase
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
    private val firebaseAuth: FirebaseAuth,
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
                        null -> {
                            SignInState.SignInError(
                                userId = userId,
                                password = password,
                                errorMessage = ""
                            )
                        }
                    }

                }
            }
        }
    }

    private fun signInWithIdToken(
        idToken: String
    ) = viewModelScope.launch {
        signInUseCase(
            params = SignInUseCase.Params(
                idToken = idToken
            )
        ).onSuccess {
            Log.d(TAG, "Entry signIn method onSuccess")
            _signInState.postValue(SignInState.SignInSuccess)
        }.onFailure {
            Log.d(TAG, "Entry signIn method onFailure")
            _signInState.postValue(
                SignInState.SignInError(
                    userId = "",
                    password = "",
                    errorMessage = it.message ?: ""
                )
            )
        }
    }

}