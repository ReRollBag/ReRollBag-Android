package com.mediaproject.data.utils.exceptions

/*
* code : 2003
* cause : token의 서명 값이 잘못된 경우
* */
class SignatureException(
    val code: Int,
    override val message: String?,
) : RuntimeException()