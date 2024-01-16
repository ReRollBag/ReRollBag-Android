package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.MarkerRepository
import javax.inject.Inject

class SaveRentingMarkerUseCase
@Inject
constructor(
    private val repository: MarkerRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.saveRentingMarker(
            latitude = params.latitude,
            longitude = params.longitude,
            name = params.name,
            maxBagsNum = params.maxBagsNum,
            currentBagsNum = params.maxBagsNum,
            imageUrl = params.imageUrl
        )
    }

    data class Params(
        val latitude: Double,
        val longitude: Double,
        val name: String,
        val maxBagsNum: Int,
        val imageUrl: String = ""
    )

}