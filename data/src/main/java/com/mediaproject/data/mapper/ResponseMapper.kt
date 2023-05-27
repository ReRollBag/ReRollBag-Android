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
    whenIsReturned = "",
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
    whenIsReturned = "",
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
    rentingUsersId = "",
    rented = false,
    whenIsReturned = whenIsReturned,
    isReturning = false,
)

@JvmName("GetReturnedBagsListResponseToModel")
internal fun GetReturnedBagsListResponse.toModel() = this.map {
    it.toModel()
}

internal fun SaveBagResponse.toModel() = BagInfo(
    bagsId = bagId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
    whenIsReturned = "",
    isReturning = false,
)

internal fun RentBagResponse.toModel() = BaseCondition(
    condition = isSuccess
)

internal fun RequestReturningBagResponse.toModel() = BaseCondition(
    condition = isSuccess
)

internal fun ReturningBagResponse.toModel() = BaseCondition(
    condition = isSuccess
)

@JvmName("FindAllRentingMarkersResponseListToModel")
internal fun FindAllRentingMarkersResponseList.toModel() = this.map {
    it.toModel()
}

@JvmName("FindAllRentingMarkersResponseToModel")
internal fun FindAllRentingMarkersResponse.toModel() = RentingMarker(
    latitude = latitude,
    longitude = longitude,
    name = name,
    maxBagsNum = maxBagsNum,
    currentBagsNum = currentBagsNum,
    imageUrl = imageUrl
)

@JvmName("FindAllReturningMarkersResponseListToModel")
internal fun FindAllReturningMarkersResponseList.toModel() = this.map {
    it.toModel()
}

@JvmName("FindAllReturningMarkersResponseToModel")
internal fun FindAllReturningMarkersResponse.toModel() = ReturningMarker(
    latitude = latitude,
    longitude = longitude,
    name = name,
    imageUrl = imageUrl
)

internal fun FindBagByIdResponse.toModel() = BagInfo(
    bagsId = bagsId,
    whenIsRented = whenIsRented,
    rentingUsersId = rentingUsersId,
    rented = rented,
    whenIsReturned = "",
    isReturning = false
)

internal fun SaveNoticeResponse.toModel() = NoticeInfo(
    title = title,
    content = content,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

internal fun GetNoticeByLastUpdatedResponse.toModel() = NoticeInfo(
    title = title,
    content = content,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

internal fun GetAllNoticesResponse.toModel() = NoticeInfo(
    title = title,
    content = content,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

internal fun GetAllNoticesListResponse.toModel() = this.map {
    it.toModel()
}

internal fun ApplyAdminResponse.toModel() = BaseCondition(
    condition = isExist
)