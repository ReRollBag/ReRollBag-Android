package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

typealias FindAllRentingMarkersResponseList = List<FindAllRentingMarkersResponse>

data class FindAllRentingMarkersResponse(
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
