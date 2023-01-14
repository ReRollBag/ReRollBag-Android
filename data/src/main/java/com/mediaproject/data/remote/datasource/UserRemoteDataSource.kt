package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.User
import com.mediaproject.domain.model.UserToken

interface UserRemoteDataSource {

    suspend fun signIn(
        userId: String,
        password: String,
    ): UserToken

    suspend fun signUp(
        userId: String,
        nickname: String,
        password: String,
    ): User

}