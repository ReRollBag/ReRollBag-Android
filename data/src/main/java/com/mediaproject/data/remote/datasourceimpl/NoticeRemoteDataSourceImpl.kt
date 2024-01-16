package com.mediaproject.data.remote.datasourceimpl

import com.mediaproject.data.mapper.toModel
import com.mediaproject.core.model.NoticeInfo
import com.mediaproject.data.remote.api.NoticeAPI
import com.mediaproject.data.remote.datasource.NoticeRemoteDataSource
import com.mediaproject.data.remote.model.request.SaveNoticeRequest
import com.mediaproject.data.utils.baseApiCall
import javax.inject.Inject

class NoticeRemoteDataSourceImpl
@Inject
constructor(
    private val noticeAPI: NoticeAPI
) : NoticeRemoteDataSource {
    override suspend fun saveNotice(
        title: String,
        content: String
    ): Unit = baseApiCall {
        noticeAPI.saveNotice(
            SaveNoticeRequest(
                title = title,
                content = content,
            )
        )
    }

    override suspend fun getNoticeByLastUpdated(): NoticeInfo = baseApiCall {
        noticeAPI.getNoticeByLastUpdated()
            .toModel()
    }

    override suspend fun getAllNotices(): List<NoticeInfo> = baseApiCall {
        noticeAPI.getAllNotices()
            .toModel()
    }
}