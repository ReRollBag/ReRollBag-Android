package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class RequestReturningBagRequest(
    @SerializedName("usersId")
    val userId: String,
    @SerializedName("bagsId")
    val bagId: String,
)
