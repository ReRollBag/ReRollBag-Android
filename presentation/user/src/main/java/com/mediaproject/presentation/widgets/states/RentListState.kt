package com.mediaproject.presentation.widgets.states

import com.mediaproject.core.model.BagInfo

sealed class RentListState(
    val list: List<com.mediaproject.core.model.BagInfo>
) {
    object Init : RentListState(list = listOf())
    data class Update(
        val fetchList: List<com.mediaproject.core.model.BagInfo>
    ) : RentListState(list = fetchList)
}
