package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.BaseCondition
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.model.User
import com.mediaproject.domain.model.UserToken

interface UserRemoteDataSource {

    suspend fun signIn(): UserToken

    suspend fun signUp(
        userId: String,
        name: String,
        idToken: String,
        userRole: String,
    ): UserToken

    suspend fun isExistUser(
        userId: String
    ): BaseCondition

    @Deprecated("Non-Used")
    suspend fun isExistNickname(
        nickname: String
    ): BaseCondition

    suspend fun getUserInfoByToken(): User

    suspend fun getRentingBagsListWithUserToken(): List<BagInfo>

    suspend fun getReturningBagsListWithUserToken(): List<BagInfo>

    suspend fun getReturnedBagsListWithUserToken(): List<BagInfo>

    suspend fun isAdminUser(): BaseCondition
}