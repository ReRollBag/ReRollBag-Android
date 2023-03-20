package com.mediaproject.data.repository

import com.mediaproject.data.remote.datasource.MarkerRemoteDataSource
import com.mediaproject.domain.model.RentingMarker
import com.mediaproject.domain.model.ReturningMarker
import com.mediaproject.domain.repository.MarkerRepository
import javax.inject.Inject

class MarkerRepositoryImpl
@Inject
constructor(
    private val markerRemoteDataSource: MarkerRemoteDataSource
) : MarkerRepository {

    override suspend fun saveRentingMarker(
        latitude: Double,
        longitude: Double,
        name: String,
        maxBagsNum: Int,
        currentBagsNum: Int,
        imageUrl: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun findAllRentingMarkers(): List<RentingMarker> = markerRemoteDataSource.findAllRentingMarkers()

    override suspend fun saveReturningMarkers(
        latitude: Double,
        longitude: Double,
        name: String,
        imageUrl: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun findAllReturningMarkers(): List<ReturningMarker> = markerRemoteDataSource.findAllReturningMarkers()

}