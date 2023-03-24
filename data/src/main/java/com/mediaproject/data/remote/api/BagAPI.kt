package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.RentBagRequest
import com.mediaproject.data.remote.model.request.RequestReturningBagRequest
import com.mediaproject.data.remote.model.request.SaveBagRequest
import com.mediaproject.data.remote.model.response.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BagAPI {

    @POST("/api/v3/bags/save")
    suspend fun saveBag(
        @Body request: SaveBagRequest
    ): SaveBagResponse

    @POST("/api/v2/bags/renting")
    suspend fun rentBag(
        @Body request: RentBagRequest
    ): RentBagResponse

    @POST("/api/v2/bags/requestReturning")
    suspend fun requestReturningBag(
        @Body request: RequestReturningBagRequest
    ): RequestReturningBagResponse

    @POST("/api/v3/bags/returning/{bagsId}")
    suspend fun returningBag(
        @Path("bagsId") bagId: String
    ): ReturningBagResponse

    @GET("/api/v1/bags/findById/{bagsId}")
    suspend fun findBagById(
        @Path("bagsId") bagId: String
    ): FindBagByIdResponse

}