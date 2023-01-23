package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class IsExistNicknameResponse(
    @SerializedName("data")
    val isExist: Boolean,
)