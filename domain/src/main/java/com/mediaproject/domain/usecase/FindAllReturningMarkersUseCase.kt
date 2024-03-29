package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.MarkerRepository
import javax.inject.Inject

class FindAllReturningMarkersUseCase
@Inject
constructor(
    private val repository: MarkerRepository
) {

    suspend operator fun invoke() = kotlin.runCatching {
        repository.findAllReturningMarkers()
    }

}