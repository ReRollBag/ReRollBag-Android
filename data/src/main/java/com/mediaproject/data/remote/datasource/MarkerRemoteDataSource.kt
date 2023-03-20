package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.RentingMarker
import com.mediaproject.domain.model.ReturningMarker

interface MarkerRemoteDataSource {

    suspend fun saveRentingMarkerWithInfo(
        latitude: Double,
        longitude: Double,
        name: String,
        maxBagsNum: Int,
        currentBagsNum: Int,
        imageUrl: String
    )

    suspend fun findAllRentingMarkers(): List<RentingMarker>

    suspend fun saveReturningMarkers(
        latitude: Double,
        longitude: Double,
        name: String,
        imageUrl: String
    )

    suspend fun findAllReturningMarkers(): List<ReturningMarker>

}