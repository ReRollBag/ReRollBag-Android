package com.mediaproject.rerollbag.di

import com.mediaproject.data.remote.api.UserAPI
import com.mediaproject.rerollbag.utils.interceptors.AuthInterceptor
import com.mediaproject.rerollbag.utils.interceptors.NullOrEmptyConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //region OkHttpClient

    @Provides
    fun providerAuthInterceptor(): AuthInterceptor = AuthInterceptor()

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun providerHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    //endregion

    //region Retrofit

    private const val BASE_URL = "http://34.64.247.152:8080"

    @Provides
    fun provideNullOrEmptyConverterFactory(): NullOrEmptyConverterFactory = NullOrEmptyConverterFactory()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        nullOrEmptyConverterFactory: NullOrEmptyConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .addConverterFactory(nullOrEmptyConverterFactory)
        .build()

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    //endregion

    @Provides
    fun providerUserAPI(
        retrofit: Retrofit
    ): UserAPI = retrofit.create(UserAPI::class.java)

}