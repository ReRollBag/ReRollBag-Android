package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.remote.api.BagAPI
import com.mediaproject.data.remote.datasource.BagRemoteDataSource
import javax.inject.Inject

class BagRemoteDataSourceImpl
@Inject
constructor(
    private val bagAPI: BagAPI
) : BagRemoteDataSource {

    override suspend fun saveBag(
        countryCode: String,
        regionCode: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun rentBag(
        userId: String,
        bagId: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun requestReturningBag(
        userId: String,
        bagId: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun returningBag(
        bagId: String
    ) {
        TODO("Not yet implemented")
    }

}