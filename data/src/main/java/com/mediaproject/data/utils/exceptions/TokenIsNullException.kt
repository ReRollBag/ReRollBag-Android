package com.mediaproject.data.utils.exceptions

/*
* code : 2002
* cause : token 값이 필요하지만 null 인 경우
* */
class TokenIsNullException(
    val code: Int,
    override val message: String?,
) : RuntimeException()