package com.mediaproject.data.remote.datasource

interface BagRemoteDataSource {

    suspend fun saveBag(
        countryCode: String,
        regionCode: String,
    )

    suspend fun rentBag(
        userId: String,
        bagId: String,
    )
    
    suspend fun requestReturningBag(
        userId: String,
        bagId: String,
    )

    suspend fun returningBag(
        bagId: String
    )

}