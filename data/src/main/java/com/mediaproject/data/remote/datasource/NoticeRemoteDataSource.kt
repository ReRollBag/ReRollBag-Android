package com.mediaproject.data.remote.datasource

import com.mediaproject.domain.model.NoticeInfo

interface NoticeRemoteDataSource {

    suspend fun saveNotice(
        title: String,
        content: String,
    )

    suspend fun getNoticeByLastUpdated(): NoticeInfo

    suspend fun getAllNotices(): List<NoticeInfo>
}