package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.BaseCondition
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
        userRole: String,
    ): UserToken

    suspend fun isExistUser(
        userId: String
    ): BaseCondition

    suspend fun isExistNickname(
        nickname: String
    ): BaseCondition

}