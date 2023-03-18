package com.mediaproject.data.mapper

import com.mediaproject.data.remote.model.response.*
import com.mediaproject.domain.model.*

internal fun SignInResponse.toModel() = UserToken(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

internal fun SignUpResponse.toModel() = UserToken(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

internal fun IsExistUserResponse.toModel() = BaseCondition(
    condition = isExist
)

internal fun IsExistNicknameResponse.toModel() = BaseCondition(
    condition = isExist
)

internal fun ReIssueResponse.toModel() = AccessToken(
    accessToken = accessToken
)

internal fun GetUserInfoResponse.toModel() = User(
    userId = userId,
    userName = userName
)

@JvmName("GetRentingBagsResponseToModel")
internal fun GetRentingBagsResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
    isReturning = false
)

@JvmName("GetRentingBagsListResponseToModel")
internal fun GetRentingBagsListResponse.toModel() = this.map {
    it.toModel()
}

@JvmName("GetReturningBagsResponseToModel")
internal fun GetReturningBagsResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
    isReturning = true
)

@JvmName("GetReturningBagsListResponseToModel")
internal fun GetReturningBagsListResponse.toModel() = this.map {
    it.toModel()
}

@JvmName("GetReturnedBagsResponseToModel")
internal fun GetReturnedBagsResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
    isReturning = false,
)

@JvmName("GetReturnedBagsListResponseToModel")
internal fun GetReturnedBagsListResponse.toModel() = this.map {
    it.toModel()
}

internal fun RentBagResponse.toModel() = BaseCondition(
    condition = isSuccess
)

internal fun RequestReturningBagResponse.toModel() = BaseCondition(
    condition = isSuccess
)

internal fun ReturningBagResponse.toModel() = BaseCondition(
    condition = isSuccess
)