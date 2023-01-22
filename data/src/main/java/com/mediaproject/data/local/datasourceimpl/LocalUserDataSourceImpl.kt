package com.mediaproject.data.local.datasourceimpl

import com.mediaproject.data.local.datasource.DataStoreDataSource
import com.mediaproject.data.local.datasource.LocalUserDataSource
import com.mediaproject.domain.model.UserToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalUserDataSourceImpl
@Inject
constructor(
    private val dataStoreDataSource: DataStoreDataSource
) : LocalUserDataSource {

    override fun fetchAccessToken(): Flow<String> = dataStoreDataSource.fetchAccessToken()

    override fun fetchRefreshToken(): Flow<String> = dataStoreDataSource.fetchRefreshToken()

    override suspend fun saveAccessToken(accessToken: String) {
        dataStoreDataSource.saveAccessToken(token = accessToken)
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        dataStoreDataSource.saveRefreshToken(token = refreshToken)
    }

    override suspend fun saveToken(userToken: UserToken) {
        userToken.run {
            saveAccessToken(accessToken)
            saveRefreshToken(refreshToken)
        }
    }

    override suspend fun clearToken() {
        dataStoreDataSource.run {
            clearAccessToken()
            clearRefreshToken()
        }
    }

}