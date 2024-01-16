package com.mediaproject.presentation.widgets.states

import com.mediaproject.core.model.BagInfo

sealed class HomeMenuState(
    open val userId: String,
    open val userName: String,
    open val listRentingBag: List<com.mediaproject.core.model.BagInfo>,
    open val listReturningBag: List<com.mediaproject.core.model.BagInfo>,
    open val listReturnedBag: List<com.mediaproject.core.model.BagInfo>,
) {
    object Init : HomeMenuState(
        userId = "",
        userName = "",
        listRentingBag = listOf(),
        listReturningBag = listOf(),
        listReturnedBag = listOf()
    )

    data class Update(
        override val userId: String,
        override val userName: String,
        override val listRentingBag: List<com.mediaproject.core.model.BagInfo>,
        override val listReturnedBag: List<com.mediaproject.core.model.BagInfo>,
        override val listReturningBag: List<com.mediaproject.core.model.BagInfo>
    ) : HomeMenuState(
        userId = userId,
        userName = userName,
        listRentingBag = listRentingBag,
        listReturningBag = listReturningBag,
        listReturnedBag = listReturnedBag
    )

    object SignOut : HomeMenuState(
        userId = "",
        userName = "",
        listRentingBag = listOf(),
        listReturningBag = listOf(),
        listReturnedBag = listOf()
    )

}
