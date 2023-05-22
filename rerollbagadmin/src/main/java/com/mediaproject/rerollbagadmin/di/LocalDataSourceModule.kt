package com.mediaproject.rerollbagadmin.di

import com.mediaproject.data.local.datasource.LocalUserDataSource
import com.mediaproject.data.local.datasourceimpl.LocalUserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Singleton
    @Binds
    abstract fun provideLocalUserDataSource(
        localUserDataSourceImpl: LocalUserDataSourceImpl
    ): LocalUserDataSource

}