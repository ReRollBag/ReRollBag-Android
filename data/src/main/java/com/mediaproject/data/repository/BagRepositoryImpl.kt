package com.mediaproject.data.repository

import com.mediaproject.core.model.BagInfo
import com.mediaproject.core.model.BaseCondition
import com.mediaproject.data.remote.datasource.BagRemoteDataSource
import javax.inject.Inject

class BagRepositoryImpl
@Inject
constructor(
    private val remoteBagDataSource: BagRemoteDataSource,
) : BagRepository {

    override suspend fun saveBag(
        countryCode: String,
        regionCode: String
    ): BagInfo = remoteBagDataSource.saveBag(
        countryCode = countryCode,
        regionCode = regionCode
    )


    override suspend fun rentBag(
        userId: String,
        bagId: String
    ): BaseCondition = remoteBagDataSource.rentBag(
        userId = userId,
        bagId = bagId
    )

    override suspend fun requestReturningBag(
        userId: String,
        bagId: String
    ): BaseCondition = remoteBagDataSource.requestReturningBag(
        userId = userId,
        bagId = bagId
    )

    override suspend fun returningBag(
        bagId: String
    ): BaseCondition = remoteBagDataSource.returningBag(bagId = bagId)

    override suspend fun findBagById(
        bagId: String
    ): BagInfo = remoteBagDataSource.findBagById(bagId = bagId)

}