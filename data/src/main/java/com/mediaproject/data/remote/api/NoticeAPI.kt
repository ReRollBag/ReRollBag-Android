package com.mediaproject.data.remote.api

import com.mediaproject.data.remote.model.request.SaveNoticeRequest
import com.mediaproject.data.remote.model.response.GetAllNoticesListResponse
import com.mediaproject.data.remote.model.response.GetNoticeByLastUpdatedResponse
import com.mediaproject.data.remote.model.response.SaveNoticeResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface NoticeAPI {

    @POST("/api/v3/notices/save")
    suspend fun saveNotice(
        saveNoticeRequest: SaveNoticeRequest
    ): SaveNoticeResponse

    @GET("/api/v1/notices/getLastNotices")
    suspend fun getNoticeByLastUpdated(): GetNoticeByLastUpdatedResponse

    @GET("/api/v1/notices/getAllNotices")
    suspend fun getAllNotices(): GetAllNoticesListResponse

}