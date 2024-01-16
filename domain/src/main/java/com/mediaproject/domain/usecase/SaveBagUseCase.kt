package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.BagRepository
import javax.inject.Inject

class SaveBagUseCase
@Inject
constructor(
    private val repository: BagRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.saveBag(
            countryCode = params.countryCode,
            regionCode = params.regionCode
        )
    }

    data class Params(
        val countryCode: String,
        val regionCode: String
    )

}