package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SaveNoticeRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
)
