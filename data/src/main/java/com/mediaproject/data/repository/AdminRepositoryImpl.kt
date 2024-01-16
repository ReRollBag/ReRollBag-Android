package com.mediaproject.data.repository

import com.mediaproject.data.remote.datasource.AdminRemoteDataSource
import com.mediaproject.data.remote.model.request.SetUpRequest
import javax.inject.Inject

class AdminRepositoryImpl
@Inject
constructor(
    private val adminRemoteDataSource: AdminRemoteDataSource,
) : AdminRepository {

    override suspend fun applyAdmin(): Boolean = adminRemoteDataSource.applyAdmin().condition

    override suspend fun setUpAdmin(
        region: String,
        certification: Int
    ): Unit = adminRemoteDataSource.setUpAdmin(
        request = SetUpRequest(
            region =  region,
            certification = certification
        )
    )

}