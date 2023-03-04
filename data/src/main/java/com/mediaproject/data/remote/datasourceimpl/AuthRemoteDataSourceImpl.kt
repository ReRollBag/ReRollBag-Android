package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.data.remote.api.AuthAPI
import com.mediaproject.data.remote.datasource.AuthRemoteDataSource
import com.mediaproject.data.utils.baseApiCall
import com.mediaproject.domain.model.AccessToken
import javax.inject.Inject

class AuthRemoteDataSourceImpl
@Inject
constructor(
    private val authAPI: AuthAPI
) : AuthRemoteDataSource {

    override suspend fun reIssue(): AccessToken = baseApiCall {
        authAPI.reIssue().toModel()
    }

}