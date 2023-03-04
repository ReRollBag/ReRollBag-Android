package com.mediaproject.data.mapper

import com.mediaproject.data.remote.model.response.*
import com.mediaproject.domain.model.AccessToken
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

internal fun ReIssueResponse.toModel() = AccessToken(
    accessToken = accessToken
)