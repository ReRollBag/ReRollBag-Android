package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("nickname")
    val nickname: String,
)
