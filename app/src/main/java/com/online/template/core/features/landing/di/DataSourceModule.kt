package com.online.template.core.features.landing.di

import com.online.template.core.features.landing.data.remote.data_sources.RemoteDataSource
import com.online.template.core.features.landing.data.remote.data_sources.RemoteDataSourceContract
import com.online.template.core.features.landing.data.remote.services.LandingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideRemoteDataSource(landingService: LandingService): RemoteDataSourceContract =
        RemoteDataSource(landingService)
}
