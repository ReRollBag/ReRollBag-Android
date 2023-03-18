package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.BagInfo

sealed class HomeMenuState(
    val userId: String,
    val userName: String,
    val listRentingBag: List<BagInfo>,
) {
    object Init : HomeMenuState(
        userId = "",
        userName = "",
        listRentingBag = listOf()
    )

    data class Update(
        private val updateUserId: String,
        private val updateUserName: String,
        private val updateListRentingBag: List<BagInfo>,
    ) : HomeMenuState(
        userId = updateUserId,
        userName = updateUserName,
        listRentingBag = updateListRentingBag
    )

    object SignOut : HomeMenuState(
        userId = "",
        userName = "",
        listRentingBag = listOf()
    )

}
