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

    data class DuplicateCheckSuccess(
        private var state: SignUpData,
    ) : SignUpState(data = state)

    object SignUpSuccess : SignUpState(data = SignUpData())

}

data class SignUpData(
    val userId: String,
    val isExistUserId: Boolean,
    val password: String,
    val passwordCheckStr: String,
    val nickname: String,
    val isExistNickname: Boolean,
    val userRole: String,
) {
    constructor() : this(
        userId = "",
        isExistUserId = false,
        password = "",
        passwordCheckStr = "",
        nickname = "",
        isExistNickname = false,
        userRole = "",
    )

    constructor(
        userId: String,
        isExistUserId: Boolean,
        password: String,
        passwordCheckStr: String,
        nickname: String,
        isExistNickname: Boolean,
    ) : this(
        userId = userId,
        isExistUserId = isExistUserId,
        password = password,
        passwordCheckStr = passwordCheckStr,
        nickname = nickname,
        isExistNickname = isExistNickname,
        userRole = "",
    )

    constructor(signUpData: SignUpData) : this(
        userId = signUpData.userId,
        isExistUserId = signUpData.isExistUserId,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        nickname = signUpData.nickname,
        isExistNickname = signUpData.isExistNickname,
        userRole = signUpData.userRole,
    )

    constructor(
        signUpData: SignUpData,
        isExistUserId: Boolean,
        isExistNickname: Boolean,
    ) : this(
        userId = signUpData.userId,
        isExistUserId = isExistUserId,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        nickname = signUpData.nickname,
        isExistNickname = isExistNickname,
        userRole = signUpData.userRole,
    )

}