package com.mediaproject.presentation.widgets.states

import com.mediaproject.core.model.NoticeInfo

sealed class NoticeState(
    open val lastUpdatedNotice: com.mediaproject.core.model.NoticeInfo?,
    open val noticeList: List<com.mediaproject.core.model.NoticeInfo>,
) {

    object Init : NoticeState(
        lastUpdatedNotice = null,
        noticeList = listOf(),
    )

    data class Update(
        override val lastUpdatedNotice: com.mediaproject.core.model.NoticeInfo?,
        override val noticeList: List<com.mediaproject.core.model.NoticeInfo>,
    ) : NoticeState(
        lastUpdatedNotice = lastUpdatedNotice,
        noticeList = noticeList,
    )

}