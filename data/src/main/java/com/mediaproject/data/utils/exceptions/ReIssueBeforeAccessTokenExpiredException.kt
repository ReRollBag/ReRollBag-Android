package com.mediaproject.data.utils.exceptions

/*
* code : 2001
* cause : Access token 이 만료되기 전에 reissue 요청을 하는 경우
* */
class ReIssueBeforeAccessTokenExpiredException(
    val code: Int,
    override val message: String?,
) : RuntimeException()