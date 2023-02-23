package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.UserRepository
import javax.inject.Inject

class SignUpUseCase
@Inject
constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.signUp(
            userId = params.userId,
            nickname = params.nickname,
            password = params.password,
            userRole = params.userRole
        )
    }

    data class Params(
        val userId: String,
        val nickname: String,
        val password: String,
        val userRole: String,
    )
}