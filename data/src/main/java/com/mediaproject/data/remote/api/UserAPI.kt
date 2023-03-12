package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.SignUpRequest
import com.mediaproject.data.remote.model.response.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface UserAPI {

    @Headers(
        "idToken: true"
    )
    @POST("/api/v2/users/login")
    suspend fun signIn(): SignInResponse

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

    @Deprecated("Non-Used")
    @Headers("No-Authentication: true")
    @GET("/api/v2/users/checkNicknameExist/{nickname}")
    suspend fun isExistNickname(
        @Path("nickname") nickname: String
    ): IsExistNicknameResponse

    @GET("/api/v1/users/getUsersInfo")
    suspend fun getUserInfo(): GetUserInfoResponse

    @GET("/api/v1/users/getRentingBagsList")
    suspend fun getRentingBagsList(): GetRentingBagsListResponse

    @GET("/api/v1/users/getReturningBagsList")
    suspend fun getReturningBagsList(): GetReturningBagsListResponse

    @GET("/api/v1/users/getReturnedBagsList")
    suspend fun getReturnedBagsList(): GetReturnedBagsListResponse

}