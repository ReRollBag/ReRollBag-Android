package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("errorCode")
    val errorCode: Int
)
