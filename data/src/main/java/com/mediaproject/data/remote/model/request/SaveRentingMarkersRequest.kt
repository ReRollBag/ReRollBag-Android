package com.mediaproject.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class SaveRentingMarkersRequest(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("maxBagsNum")
    val maxBagsNum: Int,
    @SerializedName("currentBagsNum")
    val currentBagsNum: Int,
    @SerializedName("imageUrl")
    val imageUrl: String
)
