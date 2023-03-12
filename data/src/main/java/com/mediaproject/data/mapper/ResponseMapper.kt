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

internal fun GetRentingBagsResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
)
internal fun GetRentingBagsListResponse.toModel(): List<BagInfo> = this.map {
    it.toModel()
}.toList()

internal fun GetReturningBagsResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
)

internal fun GetReturningBagsListResponse.toModel(): List<BagInfo> = this.map {
    it.toModel()
}.toList()

internal fun GetReturnedBagsResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
)

internal fun GetReturnedBagsListResponse.toModel(): List<BagInfo> = this.map {
    it.toModel()
}.toList()
