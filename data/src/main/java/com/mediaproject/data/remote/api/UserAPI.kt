package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.SignInRequest
import com.mediaproject.data.remote.model.request.SignUpRequest
import com.mediaproject.data.remote.model.response.SignInResponse
import com.mediaproject.data.remote.model.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserAPI {

    @Headers("No-Authentication: true")
    @POST("/api/v2/users/login")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    ): SignInResponse

    @Headers("No-Authentication: true")
    @POST("/api/v2/users/save")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): SignUpResponse

}