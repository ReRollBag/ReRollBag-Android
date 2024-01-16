package com.mediaproject.presentation.widgets.states

import com.mediaproject.core.model.BagInfo

sealed class QrScanState(
    open val qrScanUrl: String,
    open val bagInfo: com.mediaproject.core.model.BagInfo?,
) {
    object Init : QrScanState(
        qrScanUrl = "",
        bagInfo = null
    )

    data class Update(
        override val qrScanUrl: String,
        override val bagInfo: com.mediaproject.core.model.BagInfo?
    ) : QrScanState(
        qrScanUrl = qrScanUrl,
        bagInfo = bagInfo
    )

    object Success : QrScanState(
        qrScanUrl = "",
        bagInfo = null
    )

}
