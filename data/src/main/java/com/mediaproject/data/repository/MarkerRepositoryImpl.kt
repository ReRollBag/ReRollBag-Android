package com.mediaproject.data.repository

import com.mediaproject.core.model.RentingMarker
import com.mediaproject.core.model.ReturningMarker
import com.mediaproject.data.remote.datasource.MarkerRemoteDataSource
import com.mediaproject.data.remote.model.request.SaveRentingMarkersRequest
import com.mediaproject.data.remote.model.request.SaveReturningMarkersRequest
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
    ): RentingMarker = markerRemoteDataSource.saveRentingMarkerWithInfo(
        request = SaveRentingMarkersRequest(
            latitude = latitude,
            longitude = longitude,
            name = name,
            maxBagsNum = maxBagsNum,
            currentBagsNum = currentBagsNum,
            imageUrl = imageUrl
        )
    )

    override suspend fun findAllRentingMarkers(): List<RentingMarker> = markerRemoteDataSource.findAllRentingMarkers()

    override suspend fun saveReturningMarker(
        latitude: Double,
        longitude: Double,
        name: String,
        imageUrl: String
    ): ReturningMarker = markerRemoteDataSource.saveReturningMarker(
        request = SaveReturningMarkersRequest(
            latitude = latitude,
            longitude = longitude,
            name = name,
            imageUrl = imageUrl
        )
    )

    override suspend fun findAllReturningMarkers(): List<ReturningMarker> = markerRemoteDataSource.findAllReturningMarkers()

}