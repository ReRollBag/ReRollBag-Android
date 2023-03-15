package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.BaseCondition

interface BagRemoteDataSource {

    suspend fun saveBag(
        countryCode: String,
        regionCode: String,
    )

    suspend fun rentBag(
        userId: String,
        bagId: String,
    ): BaseCondition
    
    suspend fun requestReturningBag(
        userId: String,
        bagId: String,
    ): BaseCondition

    suspend fun returningBag(
        bagId: String
    ): BaseCondition

}