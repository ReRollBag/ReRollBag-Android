package com.mediaproject.data.remote.datasource

import com.mediaproject.data.remote.model.request.SetUpRequest
import com.mediaproject.domain.model.BaseCondition

interface AdminRemoteDataSource {

    suspend fun applyAdmin(): BaseCondition

    suspend fun setUpAdmin(request: SetUpRequest)

}