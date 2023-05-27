package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.MarkerRepository
import javax.inject.Inject

class SaveReturningMarkerUseCase
@Inject
constructor(
    private val repository: MarkerRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.saveReturningMarker(
            latitude = params.latitude,
            longitude = params.longitude,
            name = params.name,
            imageUrl = params.imageUrl
        )
    }

    data class Params(
        val latitude: Double,
        val longitude: Double,
        val name: String,
        val imageUrl: String = ""
    )

}