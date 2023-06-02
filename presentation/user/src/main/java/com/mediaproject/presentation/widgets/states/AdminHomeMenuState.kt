package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.BagInfo

sealed class AdminHomeMenuState(
    open val userId: String,
    open val userName: String,
) {
    object Init : AdminHomeMenuState(
        userId = "",
        userName = "",
    )

    data class Update(
        override val userId: String,
        override val userName: String,
    ) : AdminHomeMenuState(
        userId = userId,
        userName = userName,
    )

    object SignOut : AdminHomeMenuState(
        userId = "",
        userName = "",
    )

}
