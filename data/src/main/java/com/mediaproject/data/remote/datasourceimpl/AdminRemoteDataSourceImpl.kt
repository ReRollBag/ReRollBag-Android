package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.data.remote.api.AdminAPI
import com.mediaproject.data.remote.datasource.AdminRemoteDataSource
import com.mediaproject.data.remote.model.request.SetUpRequest
import com.mediaproject.data.utils.baseApiCall
import com.mediaproject.domain.model.BaseCondition
import javax.inject.Inject

class AdminRemoteDataSourceImpl
@Inject
constructor(
    private val adminAPI: AdminAPI
) : AdminRemoteDataSource {
    override suspend fun applyAdmin(): BaseCondition = baseApiCall {
        adminAPI.applyAdmin().toModel()
    }

    override suspend fun setUpAdmin(request: SetUpRequest): Unit = baseApiCall {
        adminAPI.setUpAdmin(
            request = request
        )
    }

}