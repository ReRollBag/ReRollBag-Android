package com.mediaproject.data.repository

import com.mediaproject.core.model.NoticeInfo

interface NoticeRepository {

    suspend fun saveNoticeWithTitleAndContent(
        title: String,
        content: String,
    )

    suspend fun getNoticeByLastUpdated(): NoticeInfo

    suspend fun getNoticeListByAll(): List<NoticeInfo>

}