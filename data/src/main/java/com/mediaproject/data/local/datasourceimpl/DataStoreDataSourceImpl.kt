package com.mediaproject.data.local.datasourceimpl

import android.content.Context
import com.mediaproject.data.local.datasource.DataStoreDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreDataSourceImpl
@Inject
constructor(
    private val context: Context,
) : DataStoreDataSource {
    override fun fetchAccessToken(): Flow<String> {
        TODO("Not yet implemented")
    }

    override fun fetchRefreshToken(): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAccessToken(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveRefreshToken(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clearAccessToken() {
        TODO("Not yet implemented")
    }

    override suspend fun clearRefreshToken() {
        TODO("Not yet implemented")
    }


}