package com.mediaproject.rerollbagadmin.di

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.mediaproject.data.local.datasource.LocalUserDataSource
import com.mediaproject.data.remote.api.*
import com.mediaproject.data.utils.interceptors.AuthInterceptor
import com.mediaproject.data.utils.interceptors.NullOrEmptyConverterFactory
import com.mediaproject.rerollbagadmin.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //region OkHttpClient

    @Provides
    fun providerAuthInterceptor(
        localUserDataSource: LocalUserDataSource
    ): AuthInterceptor = AuthInterceptor(
        localUserDataSource = localUserDataSource
    )

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

    private const val BASE_URL = "http://34.64.122.161:8080"

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
    @Singleton
    fun provideFirebase(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideGoogleSignInClient(@ApplicationContext applicationContext: Context): GoogleSignInClient {
        val mGoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(BuildConfig.ADMIN_GOOGLE_CLIENT_KEY)
            .requestProfile()
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(applicationContext, mGoogleSignInOptions)
    }

    @Provides
    fun providerUserAPI(
        retrofit: Retrofit
    ): UserAPI = retrofit.create(UserAPI::class.java)

    @Provides
    fun providerAuthAPI(
        retrofit: Retrofit
    ): AuthAPI = retrofit.create(AuthAPI::class.java)

    @Provides
    fun providerBagAPI(
        retrofit: Retrofit
    ): BagAPI = retrofit.create(BagAPI::class.java)

    @Provides
    fun providerMarkerAPI(
        retrofit: Retrofit
    ): MarkerAPI = retrofit.create(MarkerAPI::class.java)

    @Provides
    fun providerNoticeAPI(
        retrofit: Retrofit
    ): NoticeAPI = retrofit.create(NoticeAPI::class.java)

}