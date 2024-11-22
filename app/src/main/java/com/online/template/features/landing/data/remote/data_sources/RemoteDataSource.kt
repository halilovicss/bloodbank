package com.online.template.features.landing.data.remote.data_sources

import com.online.template.features.landing.data.remote.services.LandingService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val landingService: LandingService) :
    RemoteDataSourceContract {
    override suspend fun getTest(): Response<Unit> = landingService.testRetrofit()
}