package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.AdminRepository
import javax.inject.Inject

class SetUpAdminUseCase
@Inject
constructor(
    private val adminRepository: AdminRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        adminRepository.setUpAdmin(
            region = params.region,
            certification = params.certification
        )
    }

    data class Params(
        val region: String,
        val certification: Int
    )

}