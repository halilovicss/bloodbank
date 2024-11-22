package com.online.template.core.features.landing.di

import com.online.template.core.features.landing.data.remote.data_sources.RemoteDataSourceContract
import com.online.template.core.features.landing.data.repositories.LandingRepository
import com.online.template.core.features.landing.domain.abstraction.LandingRepositoryContract
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

