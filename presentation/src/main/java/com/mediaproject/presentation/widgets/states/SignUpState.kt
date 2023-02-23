package com.mediaproject.presentation.widgets.states

sealed class SignUpState(
    var data: SignUpData,
) {
    object SignUpInit : SignUpState(data = SignUpData())

    data class SignUpLoading(
        private var state: SignUpData,
    ) : SignUpState(data = state)

    data class SignUpError(
        private var state: SignUpData,
        val errorMessage: String
    ) : SignUpState(data = state)

    data class UpdateData(
        private var state: SignUpData
    ) : SignUpState(data = state)

    object SignUpSuccess : SignUpState(data = SignUpData())

}

data class SignUpData(
    val userId: String,
    val isExistUserId: Boolean,
    val password: String,
    val passwordCheckStr: String,
    val name: String,
    val userRole: String,
) {
    constructor() : this(
        userId = "",
        isExistUserId = false,
        password = "",
        passwordCheckStr = "",
        name = "",
        userRole = "",
    )

    constructor(
        userId: String,
        isExistUserId: Boolean,
        password: String,
        passwordCheckStr: String,
        name: String,
    ) : this(
        userId = userId,
        isExistUserId = isExistUserId,
        password = password,
        passwordCheckStr = passwordCheckStr,
        name = name,
        userRole = "",
    )

    constructor(signUpData: SignUpData) : this(
        userId = signUpData.userId,
        isExistUserId = signUpData.isExistUserId,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        name = signUpData.name,
        userRole = signUpData.userRole,
    )

    constructor(
        signUpData: SignUpData,
        isExistUserId: Boolean,
    ) : this(
        userId = signUpData.userId,
        isExistUserId = isExistUserId,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        name = signUpData.name,
        userRole = signUpData.userRole,
    )

}