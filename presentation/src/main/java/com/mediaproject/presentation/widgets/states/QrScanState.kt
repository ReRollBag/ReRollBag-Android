package com.mediaproject.presentation.widgets.states

import com.mediaproject.domain.model.BagInfo

sealed class QrScanState(
    open val qrScanUrl: String,
    open val bagInfo: BagInfo?,
) {
    object Init : QrScanState(
        qrScanUrl = "",
        bagInfo = null
    )

    data class Update(
        override val qrScanUrl: String,
        override val bagInfo: BagInfo?
    ) : QrScanState(
        qrScanUrl = qrScanUrl,
        bagInfo = bagInfo
    )

}
