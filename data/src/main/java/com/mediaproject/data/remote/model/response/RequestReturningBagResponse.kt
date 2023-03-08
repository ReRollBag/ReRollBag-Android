package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class RequestReturningBagResponse(
    @SerializedName("data")
    val isSuccess: Boolean,
)
