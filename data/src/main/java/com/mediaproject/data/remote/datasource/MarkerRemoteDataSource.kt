package com.mediaproject.data.remote.datasource

import com.mediaproject.core.model.RentingMarker
import com.mediaproject.core.model.ReturningMarker
import com.mediaproject.data.remote.model.request.SaveRentingMarkersRequest
import com.mediaproject.data.remote.model.request.SaveReturningMarkersRequest

interface MarkerRemoteDataSource {

    suspend fun saveRentingMarkerWithInfo(
        request: SaveRentingMarkersRequest
    ): RentingMarker

    suspend fun findAllRentingMarkers(): List<RentingMarker>

    suspend fun saveReturningMarker(
        request: SaveReturningMarkersRequest
    ): ReturningMarker

    suspend fun findAllReturningMarkers(): List<ReturningMarker>

}