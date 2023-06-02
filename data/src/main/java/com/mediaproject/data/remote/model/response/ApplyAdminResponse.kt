package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ApplyAdminResponse(
    @SerializedName("data")
    val isExist: Boolean
)
