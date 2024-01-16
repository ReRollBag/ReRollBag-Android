package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.MarkerRepository
import javax.inject.Inject

class FindAllRentingMarkersUseCase
@Inject
constructor(
    private val repository: MarkerRepository
) {

    suspend operator fun invoke() = kotlin.runCatching {
        repository.findAllRentingMarkers()
    }

}