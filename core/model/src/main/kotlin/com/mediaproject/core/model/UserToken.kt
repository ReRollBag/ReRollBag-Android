package com.mediaproject.core.model

data class UserToken(
    val accessToken: String,
    val refreshToken: String,
)
