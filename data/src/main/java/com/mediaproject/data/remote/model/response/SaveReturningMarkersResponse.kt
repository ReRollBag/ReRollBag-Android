package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SaveReturningMarkersResponse(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)
