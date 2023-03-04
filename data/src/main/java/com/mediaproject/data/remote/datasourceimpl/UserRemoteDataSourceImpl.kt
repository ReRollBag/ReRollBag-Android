package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.data.remote.api.UserAPI
import com.mediaproject.data.remote.model.request.SignUpRequest
import com.mediaproject.data.remote.datasource.UserRemoteDataSource
import com.mediaproject.data.utils.baseApiCall
import com.mediaproject.domain.model.BaseCondition
import com.mediaproject.domain.model.UserToken
import javax.inject.Inject

class UserRemoteDataSourceImpl
@Inject
constructor(
  private val userAPI: UserAPI,
) : UserRemoteDataSource {

    override suspend fun signIn(): UserToken = baseApiCall {
        userAPI.signIn().toModel()
    }

    override suspend fun signUp(
        userId: String,
        name: String,
        idToken: String,
        userRole: String
    ): UserToken = baseApiCall {
        userAPI.signUp(
            signUpRequest = SignUpRequest(
                userId = userId,
                name = name,
                idToken = idToken,
                userRole = userRole
            )
        ).toModel()
    }

    override suspend fun isExistUser(
        userId: String
    ): BaseCondition = baseApiCall {
        userAPI.isExistUser(
            userId = userId
        ).toModel()
    }

    @Deprecated("Non-Used")
    override suspend fun isExistNickname(
        nickname: String
    ): BaseCondition = baseApiCall {
        userAPI.isExistNickname(
            nickname = nickname
        ).toModel()
    }

}