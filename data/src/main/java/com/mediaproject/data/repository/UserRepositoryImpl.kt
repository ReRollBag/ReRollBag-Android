package com.mediaproject.data.repository

import android.util.Log
import com.mediaproject.data.local.datasource.LocalUserDataSource
import com.mediaproject.data.remote.datasource.UserRemoteDataSource
import com.mediaproject.domain.repository.UserRepository
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

    override suspend fun signIn(
        userId: String,
        password: String
    ) {
        remoteUserDataSource.signIn(
            userId = userId,
            password = password,
        ).also {
            Log.d(TAG, "accessToken = ${it.accessToken}, refreshToken = ${it.refreshToken} ")
            localUserDataSource.saveToken(userToken = it)
        }
    }

    override suspend fun signUp(
        userId: String,
        nickname: String,
        password: String,
        userRole: String
    ) {
        remoteUserDataSource.signUp(
            userId = userId,
            nickname = nickname,
            password = password,
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

    override suspend fun isExistNickname(
        nickname: String
    ) {
        remoteUserDataSource.isExistNickname(
            nickname = nickname
        ).also {

        }
    }

    override suspend fun clearToken() {
        localUserDataSource.clearToken()
    }

}