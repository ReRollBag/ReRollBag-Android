package com.mediaproject.data.utils.exceptions

/*
* code : 1001
* cause : 로그인을 시도하는 User 의 아이디 또는 패스워드가 틀린 경우
* */
class UsersIdOrPasswordInvalidException(
    val code: Int,
    override val message: String?,
) : RuntimeException()