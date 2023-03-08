package com.mediaproject.data.utils.exceptions

/*
* code : 1000
* cause : User Id 가 이미 존재하는 경우
* */
@Deprecated("Non-Used")
class UserIdAlreadyExistException(
    val code: Int,
    override val message: String?,
) : RuntimeException()