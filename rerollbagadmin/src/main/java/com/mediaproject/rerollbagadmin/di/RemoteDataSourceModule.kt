package com.mediaproject.rerollbagadmin.di

import com.mediaproject.data.remote.datasource.*
import com.mediaproject.data.remote.datasourceimpl.*
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

    @Singleton
    @Binds
    abstract fun providerBagDataSource(
        remoteBagDataSourceImpl: BagRemoteDataSourceImpl
    ): BagRemoteDataSource

    @Singleton
    @Binds
    abstract fun providerMarkerDataSource(
        remoteMarkerDataSourceImpl: MarkerRemoteDataSourceImpl
    ): MarkerRemoteDataSource

    @Singleton
    @Binds
    abstract fun providerNoticeDataSource(
        remoteNoticeDataSourceImpl: NoticeRemoteDataSourceImpl
    ): NoticeRemoteDataSource

}