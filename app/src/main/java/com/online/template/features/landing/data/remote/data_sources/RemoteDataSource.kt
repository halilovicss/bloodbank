package com.online.template.features.landing.data.remote.data_sources

import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.data.remote.models.RegistrationResponseModel
import com.online.template.features.landing.data.remote.services.LandingService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val landingService: LandingService) :
    RemoteDataSourceContract {
    override suspend fun getTest(): Response<Unit> = landingService.testRetrofit()
    override suspend fun registerUser(registrationRequestModel: RegistrationRequestModel): Response<RegistrationResponseModel> =
        landingService.registerUser(registrationRequestModel)
}