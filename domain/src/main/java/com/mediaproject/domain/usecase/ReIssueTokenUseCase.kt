package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.UserRepository
import javax.inject.Inject

class ReIssueTokenUseCase
@Inject
constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke() = kotlin.runCatching {
        repository.reIssueToken()
    }

}