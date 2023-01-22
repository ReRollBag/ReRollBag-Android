package com.mediaproject.data.utils.exceptions

class UnknownHttpException(
    val code: Int,
    override val message: String?,
) : RuntimeException()