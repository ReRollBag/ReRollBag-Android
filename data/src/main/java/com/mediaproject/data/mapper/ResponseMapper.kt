package com.mediaproject.data.mapper

import com.mediaproject.data.remote.model.response.SignInResponse
import com.mediaproject.data.remote.model.response.SignUpResponse
import com.mediaproject.domain.model.User
import com.mediaproject.domain.model.UserToken

internal fun SignInResponse.toModel() = UserToken(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

internal fun SignUpResponse.toModel() = User(
    userId = userId,
    nickname = nickname,
)