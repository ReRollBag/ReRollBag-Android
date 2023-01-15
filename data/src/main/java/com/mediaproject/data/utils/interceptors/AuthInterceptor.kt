package com.mediaproject.data.utils.interceptors

import com.mediaproject.data.local.datasource.LocalUserDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor
@Inject
constructor(
    private val localUserDataSource: LocalUserDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        var request = request()

        if(request.header("No-Authentication") == null){
            val accessToken = runBlocking {
                localUserDataSource.fetchAccessToken().first()
            }

            request = request.newBuilder()
                .addHeader(
                    name = "Authorization",
                    value = accessToken
                )
                .build()
        }

        proceed(request)
    }
}
