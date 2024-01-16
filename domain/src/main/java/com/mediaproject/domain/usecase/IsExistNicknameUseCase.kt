package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.UserRepository
import javax.inject.Inject

@Deprecated("Un-Used")
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