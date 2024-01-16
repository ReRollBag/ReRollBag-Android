package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.UserRepository
import javax.inject.Inject

class IsAlreadyLoginUseCase
@Inject
constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke() = kotlin.runCatching {
        repository.isAlreadyLogin()
    }
}