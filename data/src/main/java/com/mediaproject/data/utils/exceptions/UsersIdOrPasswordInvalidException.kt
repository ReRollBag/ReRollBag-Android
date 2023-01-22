package com.mediaproject.data.utils.exceptions

class UsersIdOrPasswordInvalidException(
    val code: Int,
    override val message: String?,
) : RuntimeException()