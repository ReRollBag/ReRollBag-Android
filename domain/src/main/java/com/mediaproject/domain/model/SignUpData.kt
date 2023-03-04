package com.mediaproject.domain.model

data class SignUpData(
    val userId: String,
    val isCheckDuplication: Boolean,
    val password: String,
    val passwordCheckStr: String,
    val name: String,
    val userRole: String,
) {
    constructor() : this(
        userId = "",
        isCheckDuplication = false,
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
        isCheckDuplication = isExistUserId,
        password = password,
        passwordCheckStr = passwordCheckStr,
        name = name,
        userRole = "",
    )

    constructor(signUpData: SignUpData) : this(
        userId = signUpData.userId,
        isCheckDuplication = signUpData.isCheckDuplication,
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
        isCheckDuplication = isExistUserId,
        password = signUpData.password,
        passwordCheckStr = signUpData.passwordCheckStr,
        name = signUpData.name,
        userRole = signUpData.userRole,
    )

}