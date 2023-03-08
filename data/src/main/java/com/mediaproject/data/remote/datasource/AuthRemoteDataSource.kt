package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.AccessToken

interface AuthRemoteDataSource {

    suspend fun reIssue(): AccessToken

}