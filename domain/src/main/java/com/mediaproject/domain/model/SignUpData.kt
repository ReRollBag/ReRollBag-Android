package com.mediaproject.domain.model

data class SignUpData(
    val userId: String,
    val isCheckDuplication: Boolean,
    val isErrorDuplication: Boolean,
    val password: String,
    val passwordCheckStr: String,
    val name: String,
    val userRole: String,
) {
    constructor() : this(
        userId = "",
        isCheckDuplication = false,
        isErrorDuplication = false,
        password = "",
        passwordCheckStr = "",
        name = "",
        userRole = "",
    )

    constructor(
        userId: String,
        isCheckDuplication: Boolean,
        isErrorDuplication: Boolean,
        password: String,
        passwordCheckStr: String,
        name: String,
    ) : this(
        userId = userId,
        isCheckDuplication = isCheckDuplication,
        isErrorDuplication = isErrorDuplication,
        password = password,
        passwordCheckStr = passwordCheckStr,
        name = name,
        userRole = "",
    )

    constructor(signUpData: SignUpData) : this(
        userId = signUpData.userId,
        isCheckDuplication = signUpData.isCheckDuplication,
        isErrorDuplication = signUpData.isErrorDuplication,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        name = signUpData.name,
        userRole = signUpData.userRole,
    )

    constructor(
        signUpData: SignUpData,
        isExistUserId: Boolean,
        isErrorDuplication: Boolean,
    ) : this(
        userId = signUpData.userId,
        isCheckDuplication = isExistUserId,
        isErrorDuplication = isErrorDuplication,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        name = signUpData.name,
        userRole = signUpData.userRole,
    )
}