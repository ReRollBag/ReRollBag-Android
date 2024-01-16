package com.mediaproject.data.repository

import com.mediaproject.core.model.BagInfo
import com.mediaproject.core.model.User

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

    suspend fun signOut()

    suspend fun isExistUserId(
        userId: String
    )

    @Deprecated("Non-Used")
    suspend fun isExistNickname(
        nickname: String
    )

    suspend fun clearToken()

    suspend fun reIssueToken()

    suspend fun isAlreadyLogin()

    suspend fun getUserInfo(): User

    suspend fun getUserRentingBagsList(): List<BagInfo>

    suspend fun getUserReturningBagsList(): List<BagInfo>

    suspend fun getUserReturnedBagsList(): List<BagInfo>

    suspend fun isAdminUser(): Boolean

}