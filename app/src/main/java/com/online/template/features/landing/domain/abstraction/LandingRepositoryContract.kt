package com.online.template.features.landing.domain.abstraction

import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.data.remote.models.RegistrationResponseModel

interface LandingRepositoryContract {
    suspend fun getTest(): Unit
    suspend fun registerUser(registrationRequestModel: RegistrationRequestModel): RegistrationResponseModel
}