package com.mediaproject.data.utils

import android.util.Log
import com.google.gson.Gson
import com.mediaproject.data.remote.model.response.ErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend inline fun <T> baseApiCall(
    crossinline function: suspend () -> T,
): T = try {
    withContext(Dispatchers.IO) {
        function.invoke()
    }
} catch (e: HttpException) {
    val message = getErrorMessage(e)

    throw when (e.code()) {
        else -> {
            throw Exception()
        }
    }
} catch (e: Exception) {
    Log.d("BaseApi", e.message ?: "")
    throw Exception()
}

private const val UnknownErrorMessage: String = "Unknown Error"

fun getErrorMessage(exception: HttpException): String {
    val errorString = exception.response()?.errorBody()?.string()
    val errorDto: ErrorResponse? = Gson().fromJson(
        errorString, ErrorResponse::class.java
    )

    return "[${errorDto?.errorCode ?: -1}] ${errorDto?.message ?: UnknownErrorMessage}"
}