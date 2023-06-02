package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SetUpRequest(
    @SerializedName("region")
    val region: String,
    @SerializedName("certificationNumber")
    val certification: Int
)
