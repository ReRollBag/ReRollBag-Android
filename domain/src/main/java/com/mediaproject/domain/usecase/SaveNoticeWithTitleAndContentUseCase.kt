package com.mediaproject.domain.usecase

import com.mediaproject.domain.repository.NoticeRepository
import javax.inject.Inject

class SaveNoticeWithTitleAndContentUseCase
@Inject
constructor(
    private val repository: NoticeRepository
) {

    suspend operator fun invoke(
        params: Params
    ) = kotlin.runCatching {
        repository.saveNoticeWithTitleAndContent(
            title = params.title,
            content = params.content,
        )
    }

    data class Params(
        val title: String,
        val content: String
    )

}