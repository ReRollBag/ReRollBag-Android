package com.mediaproject.data.repository

import android.util.Log
import com.mediaproject.data.local.datasource.LocalUserDataSource
import com.mediaproject.data.remote.datasource.UserRemoteDataSource
import com.mediaproject.domain.repository.UserRepository
import okhttp3.internal.wait
import javax.inject.Inject

class UserRepositoryImpl
@Inject
constructor(
    private val remoteUserDataSource: UserRemoteDataSource,
    private val localUserDataSource: LocalUserDataSource,
) : UserRepository {
    companion object {
        private const val TAG = "[UserRepo]"
    }

    override suspend fun signIn(idToken: String) {
        localUserDataSource.saveIdToken(idToken = idToken)
        remoteUserDataSource.signIn().also {
            Log.d(TAG, "accessToken = ${it.accessToken}, refreshToken = ${it.refreshToken} ")
            localUserDataSource.saveToken(userToken = it)
        }
    }

    override suspend fun signUp(
        userId: String,
        name: String,
        idToken: String,
        userRole: String
    ) {
        remoteUserDataSource.signUp(
            userId = userId,
            name = name,
            idToken = idToken,
            userRole = userRole
        ).also {
            Log.d(TAG, "accessToken = ${it.accessToken}, refreshToken = ${it.refreshToken}")
            localUserDataSource.saveToken(userToken = it)
        }
    }

    override suspend fun isExistUserId(
        userId: String
    ) {
        remoteUserDataSource.isExistUser(
            userId = userId
        ).also {
            if (!(it.condition)) {
                throw Exception()
            }
        }
    }

    @Deprecated("Non-Used")
    override suspend fun isExistNickname(nickname: String) {
        remoteUserDataSource.isExistNickname(nickname = nickname).also {
            if (!(it.condition)) {
                throw Exception()
            }
        }
    }

    override suspend fun clearToken() {
        localUserDataSource.clearToken()
    }

}