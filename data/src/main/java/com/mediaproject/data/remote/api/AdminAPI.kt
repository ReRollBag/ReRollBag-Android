package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.SetUpRequest
import com.mediaproject.data.remote.model.response.ApplyAdminResponse
import com.mediaproject.data.remote.model.response.SetUpResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface AdminAPI {

    @POST("/api/v1/users/requestAdmin")
    suspend fun applyAdmin(): ApplyAdminResponse

    @PUT("/api/v1/users/verifyAdminRequestCertificationNumber")
    suspend fun setUpAdmin(
        @Body request: SetUpRequest
    ): SetUpResponse

}