package com.mediaproject.domain.repository

import com.mediaproject.domain.model.RentingMarker
import com.mediaproject.domain.model.ReturningMarker

interface MarkerRepository {

    suspend fun saveRentingMarker(
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