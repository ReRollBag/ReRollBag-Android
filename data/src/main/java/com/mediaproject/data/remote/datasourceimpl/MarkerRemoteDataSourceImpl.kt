package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.data.remote.api.MarkerAPI
import com.mediaproject.data.remote.datasource.MarkerRemoteDataSource
import com.mediaproject.data.remote.model.request.SaveRentingMarkersRequest
import com.mediaproject.data.remote.model.request.SaveReturningMarkersRequest
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
        request: SaveRentingMarkersRequest
    ): RentingMarker = baseApiCall {
        markerAPI.saveRentingMarker(
           request = request
        ).toModel()
    }

    override suspend fun findAllRentingMarkers(): List<RentingMarker> = baseApiCall {
        markerAPI.findAllRentingMarkers().toModel()
    }

    override suspend fun saveReturningMarker(
        request: SaveReturningMarkersRequest
    ): ReturningMarker = baseApiCall {
        markerAPI.saveReturningMarker(
            request = request
        ).toModel()
    }

    override suspend fun findAllReturningMarkers(): List<ReturningMarker> = baseApiCall {
        markerAPI.findAllReturningMarkers().toModel()
    }

}