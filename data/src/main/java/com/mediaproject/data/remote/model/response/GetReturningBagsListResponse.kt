package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

typealias GetReturningBagsListResponse = List<GetReturningBagsResponse>;

data class GetReturningBagsResponse(
    @SerializedName("bagsId")
    val bagsId: String,
    @SerializedName("whenIsRented")
    val whenIsRented: String,
    @SerializedName("rentingUsersId")
    val rentingUsersId: String,
    @SerializedName("rented")
    val rented: Boolean,
)