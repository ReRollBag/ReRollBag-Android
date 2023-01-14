package com.mediaproject.domain.model

data class UserToken(
    val accessToken: String,
    val refreshToken: String,
)
