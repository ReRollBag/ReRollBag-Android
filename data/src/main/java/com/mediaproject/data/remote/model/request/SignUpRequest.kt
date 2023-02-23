package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("usersId")
    val userId: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("userRole")
    val userRole: String
)
