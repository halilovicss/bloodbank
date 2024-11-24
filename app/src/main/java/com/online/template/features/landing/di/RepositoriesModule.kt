package com.online.template.features.landing.di

import com.online.template.features.landing.data.remote.data_sources.RemoteDataSourceContract
import com.online.template.features.landing.data.repositories.LandingRepository
import com.online.template.features.landing.domain.abstraction.LandingRepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    fun providesArtistDetailRepository(
        remoteDataSourceContract: RemoteDataSourceContract,
    ): LandingRepositoryContract =
        LandingRepository(remoteDataSourceContract)
}

