package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.data.remote.api.BagAPI
import com.mediaproject.data.remote.datasource.BagRemoteDataSource
import com.mediaproject.data.remote.model.request.RentBagRequest
import com.mediaproject.data.remote.model.request.RequestReturningBagRequest
import com.mediaproject.data.remote.model.request.SaveBagRequest
import com.mediaproject.data.utils.baseApiCall
import com.mediaproject.domain.model.BagInfo
import com.mediaproject.domain.model.BaseCondition
import javax.inject.Inject

class BagRemoteDataSourceImpl
@Inject
constructor(
    private val bagAPI: BagAPI
) : BagRemoteDataSource {

    override suspend fun saveBag(
        countryCode: String,
        regionCode: String
    ): BagInfo = baseApiCall {
        bagAPI.saveBag(
            SaveBagRequest(
                countryCode = countryCode,
                regionCode = regionCode
            )
        ).toModel()
    }

    override suspend fun rentBag(
        userId: String,
        bagId: String
    ): BaseCondition = baseApiCall {
        bagAPI.rentBag(
            RentBagRequest(
                userId = userId,
                bagId = bagId
            )
        ).toModel()
    }

    override suspend fun requestReturningBag(
        userId: String,
        bagId: String
    ): BaseCondition = baseApiCall {
        bagAPI.requestReturningBag(
            RequestReturningBagRequest(
                userId = userId,
                bagId = bagId,
            )
        ).toModel()
    }

    override suspend fun returningBag(
        bagId: String
    ): BaseCondition = baseApiCall {
        bagAPI.returningBag(
            bagId = bagId
        ).toModel()
    }

}