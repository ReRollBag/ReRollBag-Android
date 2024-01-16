package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.UserRepository
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
            idToken = params.idToken
        )
    }

    data class Params(
        val idToken: String
    )
}