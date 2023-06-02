package com.mediaproject.presentation.widgets.states

sealed class BagState(
    open val countryCode: String,
    open val regionCode: String,
) {

    object Init : BagState(
        countryCode = "",
        regionCode = ""
    )

    data class Update(
        override val countryCode: String,
        override val regionCode: String,
    ) : BagState(
        countryCode = countryCode,
        regionCode = regionCode
    )

    object Success : BagState(
        countryCode = "",
        regionCode = ""
    )

}