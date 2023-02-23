package com.mediaproject.data.utils.exceptions

/*
* code : 2000
* cause : token 이 expired 된 경우
* */
class ExpiredJwtException(
    val code: Int,
    override val message: String?,
) : RuntimeException()