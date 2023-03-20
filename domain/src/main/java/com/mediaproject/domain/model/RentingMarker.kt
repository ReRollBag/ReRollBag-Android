package com.mediaproject.domain.model


data class RentingMarker
constructor(
    override val latitude: Double,
    override val longitude: Double,
    override val name: String,
    val maxBagsNum: Int,
    val currentBagsNum: Int,
    override val imageUrl: String,
): ReRollBagMarker()
