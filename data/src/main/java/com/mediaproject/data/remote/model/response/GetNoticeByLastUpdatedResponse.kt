package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class GetNoticeByLastUpdatedResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
)
