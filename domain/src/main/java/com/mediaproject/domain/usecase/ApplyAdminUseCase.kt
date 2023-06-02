package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.AdminRepository
import javax.inject.Inject

class ApplyAdminUseCase
@Inject
constructor(
    private val adminRepository: AdminRepository
) {

    suspend operator fun invoke(): Boolean = kotlin.runCatching {
        adminRepository.applyAdmin()
    }.getOrDefault(false)

}