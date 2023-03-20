package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.data.remote.api.MarkerAPI
import com.mediaproject.data.remote.datasource.MarkerRemoteDataSource
import com.mediaproject.data.utils.baseApiCall
import com.mediaproject.domain.model.RentingMarker
import com.mediaproject.domain.model.ReturningMarker
import javax.inject.Inject

class MarkerRemoteDataSourceImpl
@Inject
constructor(
    private val markerAPI: MarkerAPI
) : MarkerRemoteDataSource {

    override suspend fun saveRentingMarkerWithInfo(
        latitude: Double,
        longitude: Double,
        name: String,
        maxBagsNum: Int,
        currentBagsNum: Int,
        imageUrl: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun findAllRentingMarkers(): List<RentingMarker> = baseApiCall {
        markerAPI.findAllRentingMarkers().toModel()
    }

    override suspend fun saveReturningMarkers(
        latitude: Double,
        longitude: Double,
        name: String,
        imageUrl: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun findAllReturningMarkers(): List<ReturningMarker> = baseApiCall {
        markerAPI.findAllReturningMarkers().toModel()
    }

}