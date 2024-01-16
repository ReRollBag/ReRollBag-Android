package com.mediaproject.presentation.widgets.states

import com.mediaproject.core.model.SignUpData

sealed class SignUpState(
    var data: com.mediaproject.core.model.SignUpData,
//    val errorMessage: String,
) {
    object SignUpInit : SignUpState(
        data = com.mediaproject.core.model.SignUpData(),
    )

    data class SignUpLoading(
        private var state: com.mediaproject.core.model.SignUpData,
    ) : SignUpState(data = state,)

    data class SignUpError(
        private var state: com.mediaproject.core.model.SignUpData,
        val errorMessage: String
    ) : SignUpState(data = state)

    data class UpdateData(
        private var state: com.mediaproject.core.model.SignUpData
    ) : SignUpState(data = state)

    object SignUpSuccess : SignUpState(data = com.mediaproject.core.model.SignUpData())

}