package com.mediaproject.data.remote.datasource

import com.mediaproject.core.model.AccessToken

interface AuthRemoteDataSource {

    suspend fun reIssue(): AccessToken

}