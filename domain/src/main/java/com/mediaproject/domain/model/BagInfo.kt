package com.mediaproject.domain.model

data class BagInfo(
    val bagsId: String,
    val whenIsRented: String,
    val rentingUsersId: String,
    val rented: Boolean,
    val whenIsReturned: String,
    val isReturning: Boolean,
) {
    constructor(
        bagsId: String
    ) : this(
        bagsId = bagsId,
        whenIsRented = "",
        rentingUsersId = "",
        rented = false,
        whenIsReturned = "",
        isReturning = false,
    )
}
