package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ReIssueResponse (
    @SerializedName("accessToken")
    val accessToken: String,
)