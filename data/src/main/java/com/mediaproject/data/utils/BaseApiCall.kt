package com.mediaproject.data.utils

import android.util.Log
import com.google.gson.Gson
import com.mediaproject.data.remote.model.response.ErrorResponse
import com.mediaproject.data.utils.exceptions.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

private const val UnknownErrorMessage: String = "Unknown Error"

suspend inline fun <T> baseApiCall(
    crossinline function: suspend () -> T,
): T = try {
    withContext(Dispatchers.IO) {
        function.invoke()
    }
} catch (e: HttpException) {
    val response = getErrorMessage(e)

    throw when (e.code()) {
        202 -> when (response.errorCode) {
            1000 -> UserIdAlreadyExistException(code = response.errorCode, message = response.message)
            1002 -> NicknameAlreadyException(code = response.errorCode, message = response.message)
            2002 -> TokenIsNullException(code = response.errorCode, message = response.message)
            else -> UnknownHttpException(code = response.errorCode, message = response.message)
        }
        403 -> when (response.errorCode) {
            1001 -> UsersIdOrPasswordInvalidException(code = response.errorCode, message = response.message)
            1003 -> DuplicateUserSaveException(code = response.errorCode, message = response.message)
            else -> UnknownHttpException(code = response.errorCode, message = response.message)
        }
        else -> UnknownHttpException(code = response.errorCode, message = response.message)
    }
} catch (e: Exception) {
    Log.d("BaseApi", e.message ?: "")
    throw UnknownException(e.message)
}

fun getErrorMessage(exception: HttpException): ErrorResponse {
    val errorString = exception.response()?.errorBody()?.string()
    val errorDto: ErrorResponse = Gson().fromJson(
        errorString, ErrorResponse::class.java
    )
    Log.d("TAG", "errorString: ${errorDto.message}, errorCode:${errorDto.errorCode}")
    return errorDto
}