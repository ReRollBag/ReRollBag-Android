package com.mediaproject.domain.repository

interface AdminRepository {

    suspend fun applyAdmin(): Boolean

    suspend fun setUpAdmin(
        region: String,
        certification: Int
    ): Unit

}