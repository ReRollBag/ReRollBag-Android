package com.mediaproject.data.mapper

import com.mediaproject.data.remote.model.response.IsExistNicknameResponse
import com.mediaproject.data.remote.model.response.IsExistUserResponse
import com.mediaproject.data.remote.model.response.SignInResponse
import com.mediaproject.data.remote.model.response.SignUpResponse
import com.mediaproject.domain.model.BaseCondition
import com.mediaproject.domain.model.User
import com.mediaproject.domain.model.UserToken

internal fun SignInResponse.toModel() = UserToken(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

internal fun SignUpResponse.toModel() = UserToken(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

internal fun IsExistUserResponse.toModel() = BaseCondition(
    condition = isExist
)

internal fun IsExistNicknameResponse.toModel() = BaseCondition(
    condition = isExist
)