package com.mediaproject.presentation.widgets.states

sealed class SignUpState {

    object SignUpInit : SignUpState()

    object SignUpLoading : SignUpState()

    data class SignUpError(
        val userId: String,
        val isExistUserId: Boolean,
        val nickname: String,
        val isExistNickname: Boolean,
        val password: String,
        val userRole: String,
        val errorMessage: String
    ) : SignUpState()

    data class DuplicateCheckSuccess(
        val userId: String,
        val isExistUserId: Boolean,
        val nickname: String,
        val isExistNickname: Boolean,
        val password: String,
        val userRole: String,
    ) : SignUpState()

    object SignUpSuccess : SignUpState()

}
