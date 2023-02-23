package com.mediaproject.data.utils.exceptions

/*
* code : 1002
* cause : Nickname 이 이미 존재하는 경우
* */
class NicknameAlreadyException(
    val code: Int,
    override val message: String?,
) : RuntimeException()