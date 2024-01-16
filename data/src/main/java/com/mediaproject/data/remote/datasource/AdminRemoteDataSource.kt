package com.mediaproject.data.remote.datasource

import com.mediaproject.core.model.BaseCondition
import com.mediaproject.data.remote.model.request.SetUpRequest

interface AdminRemoteDataSource {

    suspend fun applyAdmin(): BaseCondition

    suspend fun setUpAdmin(request: SetUpRequest)

}