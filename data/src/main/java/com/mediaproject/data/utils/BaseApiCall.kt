package com.mediaproject.data.utils

import android.util.Log
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
    throw when (e.code()) {
        else -> {
            throw Exception()
        }
    }
} catch (e: Exception) {
    Log.d("BaseApi", e.message ?: "")
    throw Exception()
}