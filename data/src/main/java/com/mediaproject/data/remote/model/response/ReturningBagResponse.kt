package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ReturningBagResponse(
    @SerializedName("data")
    val isSuccess: Boolean,
)
