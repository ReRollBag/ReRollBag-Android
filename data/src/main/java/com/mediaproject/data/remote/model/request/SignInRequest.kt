package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("usersId")
    val userId: String,
    @SerializedName("password")
    val password: String,
)
