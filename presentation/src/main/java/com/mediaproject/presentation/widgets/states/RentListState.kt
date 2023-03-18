package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.BagInfo

sealed class RentListState(
    val list: List<BagInfo>
) {
    object Init : RentListState(list = listOf())
    data class Update(
        val fetchList: List<BagInfo>
    ) : RentListState(list = fetchList)
}
