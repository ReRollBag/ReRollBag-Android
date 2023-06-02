package com.mediaproject.presentation.widgets.states

sealed class SignInState {

    object SignInInit : SignInState()

    object SignInLoading : SignInState()

    data class SignInError(
        val userId: String,
        val password: String,
        val errorMessage: String
    ) : SignInState()

    object SignInSuccess : SignInState()

}