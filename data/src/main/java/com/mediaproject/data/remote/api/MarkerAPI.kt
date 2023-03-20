package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.SaveRentingMarkersRequest
import com.mediaproject.data.remote.model.request.SaveReturningMarkersRequest
import com.mediaproject.data.remote.model.response.FindAllRentingMarkersResponseList
import com.mediaproject.data.remote.model.response.FindAllReturningMarkersResponseList
import com.mediaproject.data.remote.model.response.SaveRentingMarkersResponse
import com.mediaproject.data.remote.model.response.SaveReturningMarkersResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MarkerAPI {

    @POST("/api/v3/markers/renting/save")
    suspend fun saveRentingMarkers(
        @Body saveRentingMarkersRequest: SaveRentingMarkersRequest
    ): SaveRentingMarkersResponse

    @GET("/api/v1/markers/renting/findAll")
    suspend fun findAllRentingMarkers(): FindAllRentingMarkersResponseList

    @POST("/api/v3/markers/returning/save")
    suspend fun saveReturningMarkers(
        @Body saveReturningMarkersRequest: SaveReturningMarkersRequest
    ): SaveReturningMarkersResponse

    @GET("/api/v1/markers/returning/findAll")
    suspend fun findAllReturningMarkers(): FindAllReturningMarkersResponseList

}