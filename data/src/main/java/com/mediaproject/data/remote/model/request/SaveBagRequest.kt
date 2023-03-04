package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SaveBagRequest(
    @SerializedName("countryCode")
    val countryCode: String,
    @SerializedName("regionCode")
    val regionCode: String,
)
