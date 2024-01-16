package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.BagRepository
import javax.inject.Inject

class ReturningBagUseCase
@Inject
constructor(
    private val repository: BagRepository
) {

    suspend operator fun invoke(bagId: String) = kotlin.runCatching {
        repository.returningBag(bagId = bagId)
    }

}