package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase
@Inject
constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.signIn(
            userId = params.userId,
            password = params.password
        )
    }

    data class Params(
        val userId: String,
        val password: String,
    )
}