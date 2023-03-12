package com.mediaproject.domain.repository

import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.model.User

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

    suspend fun getUserInfo(): User

    suspend fun getUserRentingBagsList(): List<BagInfo>

    suspend fun getUserReturningBagsList(): List<BagInfo>

    suspend fun getUserReturnedBagsList(): List<BagInfo>

}