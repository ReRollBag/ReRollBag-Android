package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SaveReturningMarkersRequest(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)
