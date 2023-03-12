package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class GetUserInfoResponse(
    @SerializedName("usersId")
    val userId: String,
    @SerializedName("name")
    val userName: String,
)