package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class RentBagResponse(
    @SerializedName("data")
    val isSuccess: Boolean,
)
