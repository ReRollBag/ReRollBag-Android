package com.mediaproject.domain.model

data class ReturningMarker
constructor(
    override val latitude: Double,
    override val longitude: Double,
    override val name: String,
    override val imageUrl: String
): ReRollBagMarker()
