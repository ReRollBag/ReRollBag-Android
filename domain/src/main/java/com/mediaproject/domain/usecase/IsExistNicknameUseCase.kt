package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.UserRepository
import javax.inject.Inject

class IsExistNicknameUseCase
@Inject
constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.isExistNickname(
            nickname = params.nickname
        )
    }

    data class Params(
        val nickname: String,
    )

}