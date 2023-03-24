package com.mediaproject.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class FindBagByIdResponse(
    @SerializedName("bagsId")
    val bagsId: String,
    @SerializedName("whenIsRented")
    val whenIsRented: String,
    @SerializedName("rentingUsersId")
    val rentingUsersId: String,
    @SerializedName("rented")
    val rented: Boolean
)
