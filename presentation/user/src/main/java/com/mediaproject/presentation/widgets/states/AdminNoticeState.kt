package com.mediaproject.presentation.widgets.states

sealed class AdminNoticeState(
    open val title: String,
    open val content: String
) {

    object Init : AdminNoticeState(
        title = "",
        content = ""
    )

    data class Update(
        override val title: String,
        override val content: String
    ) : AdminNoticeState(
        title = title,
        content = content
    )

    object Success : AdminNoticeState(
        title = "",
        content = ""
    )

}