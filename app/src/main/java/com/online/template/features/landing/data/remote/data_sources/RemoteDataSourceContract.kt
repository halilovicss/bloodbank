package com.online.template.features.landing.data.remote.data_sources

import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.data.remote.models.RegistrationResponseModel
import retrofit2.Response

interface RemoteDataSourceContract {
    suspend fun getTest(): Response<Unit>
    suspend fun registerUser(registrationRequestModel: RegistrationRequestModel): Response<RegistrationResponseModel>
}