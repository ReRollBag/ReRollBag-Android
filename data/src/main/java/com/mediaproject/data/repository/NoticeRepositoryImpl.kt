package com.mediaproject.data.repository

import com.mediaproject.core.model.NoticeInfo
import com.mediaproject.data.remote.datasource.NoticeRemoteDataSource
import javax.inject.Inject

class NoticeRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: NoticeRemoteDataSource
) : NoticeRepository {

    override suspend fun saveNoticeWithTitleAndContent(
        title: String,
        content: String
    ) = remoteDataSource.saveNotice(
        title = title,
        content = content
    )


    override suspend fun getNoticeByLastUpdated(): NoticeInfo = remoteDataSource.getNoticeByLastUpdated().apply {
        // If Notice save DataStore
    }

    override suspend fun getNoticeListByAll(): List<NoticeInfo> = remoteDataSource.getAllNotices().apply {
        // If Notice save DataStore
    }

}