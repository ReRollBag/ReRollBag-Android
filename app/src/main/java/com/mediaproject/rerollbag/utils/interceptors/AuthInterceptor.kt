package com.mediaproject.rerollbag.utils.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        var request = request()

        if(request.header("No-Authentication") == null){
            //val token = getTokenFromSharedPreference();
            //or use Token Function
            request = request.newBuilder()
                .addHeader(
                    name = "Authorization",
                    value = ""
                )
                .build()
        }

        proceed(request)
    }
}
