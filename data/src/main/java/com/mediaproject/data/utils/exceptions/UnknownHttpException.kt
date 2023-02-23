package com.mediaproject.data.utils.exceptions

/*
* code: 5000
* cause: UnHandled Exception
* */
class UnknownHttpException(
    val code: Int,
    override val message: String?,
) : RuntimeException()