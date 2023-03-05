package com.mediaproject.rerollbag.di

import com.mediaproject.data.remote.datasource.AuthRemoteDataSource
import com.mediaproject.data.remote.datasource.BagRemoteDataSource
import com.mediaproject.data.remote.datasource.UserRemoteDataSource
import com.mediaproject.data.remote.datasourceimpl.AuthRemoteDataSourceImpl
import com.mediaproject.data.remote.datasourceimpl.UserRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Singleton
    @Binds
    abstract fun providerUserDataSource(
        remoteUserDataSourceImpl: UserRemoteDataSourceImpl
    ): UserRemoteDataSource

    @Singleton
    @Binds
    abstract fun providerAuthDataSource(
        remoteAuthDataSourceImpl: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource

//    @Singleton
//    @Binds
//    abstract fun providerBagDataSource(
//
//    ): BagRemoteDataSource

}