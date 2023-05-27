package com.mediaproject.data.remote.datasource

import com.mediaproject.data.remote.model.request.SaveRentingMarkersRequest
import com.mediaproject.data.remote.model.request.SaveReturningMarkersRequest
import com.mediaproject.domain.model.RentingMarker
import com.mediaproject.domain.model.ReturningMarker

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