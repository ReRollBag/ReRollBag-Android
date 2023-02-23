package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.UserRepository
import javax.inject.Inject

class IsExistUserIdUseCase
@Inject
constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.isExistUserId(
            userId = params.userId
        )
    }

    data class Params(
        val userId: String,
    )

}