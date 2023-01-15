package com.mediaproject.data.local.datasource

import com.mediaproject.domain.model.UserToken
import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {

    fun fetchAccessToken(): Flow<String>
    fun fetchRefreshToken(): Flow<String>

    suspend fun saveAccessToken(accessToken: String)
    suspend fun saveRefreshToken(refreshToken: String)
    suspend fun saveToken(userToken: UserToken)

    suspend fun clearToken()

}