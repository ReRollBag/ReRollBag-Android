package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.response.ReIssueResponse
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthAPI {

    @Headers(
        "refreshToken: true"
    )
    @POST("/api/v2/users/reIssue")
    suspend fun reIssue(): ReIssueResponse

}