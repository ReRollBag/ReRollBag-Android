package com.mediaproject.data.local.datasource

import kotlinx.coroutines.flow.Flow

interface DataStoreDataSource {

    fun fetchAccessToken(): Flow<String>
    fun fetchRefreshToken(): Flow<String>

    suspend fun saveAccessToken(token: String)
    suspend fun saveRefreshToken(token: String)
    suspend fun clearAccessToken()
    suspend fun clearRefreshToken()
}