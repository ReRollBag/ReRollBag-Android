package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SetUpResponse(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
)
