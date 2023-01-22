package com.mediaproject.domain.repository

interface UserRepository {

    suspend fun signIn(
        userId: String,
        password: String,
    )

    suspend fun signUp(
        userId: String,
        nickname: String,
        password: String,
    )

    suspend fun clearToken()

}