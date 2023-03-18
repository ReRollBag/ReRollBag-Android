package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.BagRepository
import javax.inject.Inject

class RequestReturningBagUseCase
@Inject
constructor(
    private val repository: BagRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.requestReturningBag(
            userId = params.userId,
            bagId = params.bagId,
        )
    }

    data class Params(
        val userId: String,
        val bagId: String
    )

}