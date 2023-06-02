package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.BagInfo

sealed class HomeMenuState(
    open val userId: String,
    open val userName: String,
    open val listRentingBag: List<BagInfo>,
    open val listReturningBag: List<BagInfo>,
    open val listReturnedBag: List<BagInfo>,
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
        override val listRentingBag: List<BagInfo>,
        override val listReturnedBag: List<BagInfo>,
        override val listReturningBag: List<BagInfo>
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
