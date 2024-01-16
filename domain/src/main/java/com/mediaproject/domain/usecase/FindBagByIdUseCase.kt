package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.BagRepository
import javax.inject.Inject

class FindBagByIdUseCase
@Inject
constructor(
    private val repository: BagRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.findBagById(
            bagId = params.bagId
        )
    }

    data class Params(
        val bagId: String,
    )

}