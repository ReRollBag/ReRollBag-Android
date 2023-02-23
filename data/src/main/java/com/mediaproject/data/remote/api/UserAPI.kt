package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.SignInRequest
import com.mediaproject.data.remote.model.request.SignUpRequest
import com.mediaproject.data.remote.model.response.IsExistNicknameResponse
import com.mediaproject.data.remote.model.response.IsExistUserResponse
import com.mediaproject.data.remote.model.response.SignInResponse
import com.mediaproject.data.remote.model.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

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

    @Headers("No-Authentication: true")
    @GET("/api/v2/users/checkUserExist/{usersId}")
    suspend fun isExistUser(
        @Path("usersId") userId: String
    ): IsExistUserResponse

    @Headers("No-Authentication: true")
    @GET("/api/v2/users/checkNicknameExist/{nickname}")
    suspend fun isExistNickname(
        @Path("nickname") nickname: String
    ): IsExistNicknameResponse

}