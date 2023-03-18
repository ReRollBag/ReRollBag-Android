package com.mediaproject.domain.model

data class BagInfo(
    val bagsId: String,
    val whenIsRented: String,
    val rentingUsersId: String,
    val rented: Boolean,
    val whenIsReturned: String,
    val isReturning: Boolean,
)
