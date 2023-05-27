package com.mediaproject.rerollbag.di

import com.mediaproject.data.repository.AdminRepositoryImpl
import com.mediaproject.data.repository.BagRepositoryImpl
import com.mediaproject.data.repository.MarkerRepositoryImpl
import com.mediaproject.data.repository.NoticeRepositoryImpl
import com.mediaproject.data.repository.UserRepositoryImpl
import com.mediaproject.domain.repository.AdminRepository
import com.mediaproject.domain.repository.BagRepository
import com.mediaproject.domain.repository.MarkerRepository
import com.mediaproject.domain.repository.NoticeRepository
import com.mediaproject.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Singleton
    @Binds
    abstract fun provideBagRepository(
        bagRepositoryImpl: BagRepositoryImpl
    ): BagRepository

    @Singleton
    @Binds
    abstract fun provideMarkerRepository(
        markerRepositoryImpl: MarkerRepositoryImpl
    ): MarkerRepository

    @Singleton
    @Binds
    abstract fun provideNoticeRepository(
        noticeRepositoryImpl: NoticeRepositoryImpl
    ): NoticeRepository

    @Singleton
    @Binds
    abstract fun provideAdminRepository(
        adminRepositoryImpl: AdminRepositoryImpl
    ): AdminRepository

}