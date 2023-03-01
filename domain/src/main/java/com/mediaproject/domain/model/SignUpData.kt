package com.mediaproject.domain.model

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