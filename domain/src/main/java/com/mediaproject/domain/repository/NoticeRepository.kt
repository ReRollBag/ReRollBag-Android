package com.mediaproject.domain.repository

import com.mediaproject.domain.model.NoticeInfo

interface NoticeRepository {

    suspend fun saveNoticeWithTitleAndContent(
        title: String,
        content: String,
    )

    suspend fun getNoticeByLastUpdated(): NoticeInfo

    suspend fun getNoticeListByAll(): List<NoticeInfo>

}