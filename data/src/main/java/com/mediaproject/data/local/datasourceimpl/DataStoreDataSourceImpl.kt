package com.mediaproject.data.local.datasourceimpl

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mediaproject.data.local.datasource.DataStoreDataSource
import com.mediaproject.data.local.datastore
import com.mediaproject.data.utils.extensions.fetchStringPreference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreDataSourceImpl
@Inject
constructor(
    private val context: Context,
) : DataStoreDataSource {
    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        private val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    }

    override fun fetchAccessToken(): Flow<String> = context.fetchStringPreference(key = ACCESS_TOKEN)

    override fun fetchRefreshToken(): Flow<String> = context.fetchStringPreference(key = REFRESH_TOKEN)

    override suspend fun saveAccessToken(token: String) {
        context.datastore.edit { preference ->
            preference[ACCESS_TOKEN] = token
        }
    }

    override suspend fun saveRefreshToken(token: String) {
        context.datastore.edit { preference ->
            preference[REFRESH_TOKEN] = token
        }
    }

    override suspend fun clearAccessToken() {
        context.datastore.edit { preference ->
            preference.remove(ACCESS_TOKEN)
        }
    }

    override suspend fun clearRefreshToken() {
        context.datastore.edit { preference ->
            preference.remove(REFRESH_TOKEN)
        }
    }

}