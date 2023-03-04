package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("usersId")
    val userId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("idToken")
    val idToken: String,
    @SerializedName("userRole")
    val userRole: String
)
