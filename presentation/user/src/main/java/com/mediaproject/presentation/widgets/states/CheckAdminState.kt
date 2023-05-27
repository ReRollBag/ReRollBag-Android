package com.mediaproject.presentation.widgets.states

sealed class CheckAdminState(
    open val region: String,
    open val certification: Int
) {

    object Init : CheckAdminState(
        region = "",
        certification = 0
    )

    object Issued : CheckAdminState(
        region = "",
        certification = 0
    )

    data class Update(
        override val region: String,
        override val certification: Int
    ) : CheckAdminState(
        region = region,
        certification = certification
    )

    object Success : CheckAdminState(
        region = "",
        certification = 0
    )

}