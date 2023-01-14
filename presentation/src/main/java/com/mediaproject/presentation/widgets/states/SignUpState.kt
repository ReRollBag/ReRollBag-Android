package com.mediaproject.presentation.widgets.states

sealed class SignUpState {

    object SignUpInit : SignUpState()

    data class SignUpError(
        val userId: String,
        val nickname: String,
        val password: String,
        val errorMessage: String
    ) : SignUpState()

    object SignUpSuccess : SignUpState()

}
