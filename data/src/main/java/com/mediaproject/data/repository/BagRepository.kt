package com.mediaproject.data.repository

import com.mediaproject.core.model.BagInfo
import com.mediaproject.core.model.BaseCondition

interface BagRepository {

    suspend fun saveBag(
        countryCode: String,
        regionCode: String,
    ): BagInfo

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

    suspend fun findBagById(
        bagId: String
    ): BagInfo

}