package com.mediaproject.domain.repository

interface UserRepository {

    suspend fun signIn(
        idToken: String
    )

    suspend fun signUp(
        userId: String,
        name: String,
        idToken: String,
        userRole: String,
    )

    suspend fun isExistUserId(
        userId: String
    )

    @Deprecated("Non-Used")
    suspend fun isExistNickname(
        nickname: String
    )

    suspend fun clearToken()

    suspend fun isAlreadyLogin()

}