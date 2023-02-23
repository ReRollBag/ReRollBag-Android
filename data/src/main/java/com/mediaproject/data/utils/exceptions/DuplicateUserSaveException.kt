package com.mediaproject.data.utils.exceptions

/*
* code : 1003
* cause : 이미 존재하는 정보로 회원 가입을 시도하는 경우
* */
class DuplicateUserSaveException(
    val code: Int,
    override val message: String?,
) : RuntimeException()