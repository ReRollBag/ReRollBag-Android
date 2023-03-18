package com.mediaproject.domain.repository

import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.model.BaseCondition

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

}