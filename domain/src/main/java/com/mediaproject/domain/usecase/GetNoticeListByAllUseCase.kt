package com.mediaproject.domain.usecase

import com.mediaproject.data.repository.NoticeRepository
import javax.inject.Inject

class GetNoticeListByAllUseCase
@Inject
constructor(
    private val repository: NoticeRepository
) {

    suspend operator fun invoke() = kotlin.runCatching {
        repository.getNoticeListByAll()
    }

}