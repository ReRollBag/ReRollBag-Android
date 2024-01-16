package com.mediaproject.data.repository

import com.mediaproject.core.model.RentingMarker
import com.mediaproject.core.model.ReturningMarker

interface MarkerRepository {

    suspend fun saveRentingMarker(
        latitude: Double,
        longitude: Double,
        name: String,
        maxBagsNum: Int,
        currentBagsNum: Int,
        imageUrl: String
    ): RentingMarker

    suspend fun findAllRentingMarkers(): List<RentingMarker>

    suspend fun saveReturningMarker(
        latitude: Double,
        longitude: Double,
        name: String,
        imageUrl: String
    ): ReturningMarker

    suspend fun findAllReturningMarkers(): List<ReturningMarker>

}