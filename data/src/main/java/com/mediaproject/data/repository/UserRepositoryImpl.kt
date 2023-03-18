package com.mediaproject.data.repository

import android.util.Log
import com.mediaproject.data.local.datasource.LocalUserDataSource
import com.mediaproject.data.remote.datasource.AuthRemoteDataSource
import com.mediaproject.data.remote.datasource.UserRemoteDataSource
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.model.User
import com.mediaproject.domain.repository.UserRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UserRepositoryImpl
@Inject
constructor(
    private val remoteUserDataSource: UserRemoteDataSource,
    private val remoteAuthDataSource: AuthRemoteDataSource,
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

    override suspend fun signOut() {
        localUserDataSource.clearToken()
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

    override suspend fun reIssueToken() {
        remoteAuthDataSource.reIssue().also {
            localUserDataSource.saveAccessToken(accessToken = it.accessToken)
        }
    }

    override suspend fun isAlreadyLogin() {
        val accessToken = localUserDataSource.fetchAccessToken().first()
        val refreshToken = localUserDataSource.fetchRefreshToken().first()
        if (accessToken.isEmpty() && refreshToken.isEmpty()) {
            throw Exception()
        }
    }

    override suspend fun getUserInfo(): User = remoteUserDataSource.getUserInfoByToken()

    override suspend fun getUserRentingBagsList(): List<BagInfo> = remoteUserDataSource.getRentingBagsListWithUserToken()

    override suspend fun getUserReturningBagsList(): List<BagInfo> = remoteUserDataSource.getReturningBagsListWithUserToken()

    override suspend fun getUserReturnedBagsList(): List<BagInfo> = remoteUserDataSource.getReturnedBagsListWithUserToken()

}