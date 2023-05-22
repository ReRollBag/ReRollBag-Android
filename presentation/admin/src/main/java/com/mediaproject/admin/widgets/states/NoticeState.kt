package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.NoticeInfo

sealed class NoticeState(
    open val lastUpdatedNotice: NoticeInfo?,
    open val noticeList: List<NoticeInfo>,
) {

    object Init : NoticeState(
        lastUpdatedNotice = null,
        noticeList = listOf(),
    )

    data class Update(
        override val lastUpdatedNotice: NoticeInfo?,
        override val noticeList: List<NoticeInfo>,
    ) : NoticeState(
        lastUpdatedNotice = lastUpdatedNotice,
        noticeList = noticeList,
    )

}