package com.online.template.core.features.landing.di

import com.online.template.core.di.PublicRetrofit
import com.online.template.core.features.landing.data.remote.services.LandingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideArtistDetailService(@PublicRetrofit retrofit: Retrofit): LandingService =
        retrofit.create(LandingService::class.java)
}
