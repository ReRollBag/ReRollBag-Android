package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.SignUpData

sealed class SignUpState(
    var data: SignUpData,
//    val errorMessage: String,
) {
    object SignUpInit : SignUpState(
        data = SignUpData(),
    )

    data class SignUpLoading(
        private var state: SignUpData,
    ) : SignUpState(data = state,)

    data class SignUpError(
        private var state: SignUpData,
        val errorMessage: String
    ) : SignUpState(data = state)

    data class UpdateData(
        private var state: SignUpData
    ) : SignUpState(data = state)

    object SignUpSuccess : SignUpState(data = SignUpData())

}