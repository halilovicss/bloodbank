package com.online.template.features.landing.data.repositories

import com.online.template.features.landing.data.remote.data_sources.RemoteDataSourceContract
import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.data.remote.models.RegistrationResponseModel
import com.online.template.features.landing.domain.abstraction.LandingRepositoryContract
import com.online.template.helpers.view.getErrorMessage
import javax.inject.Inject

class LandingRepository @Inject constructor(private val remoteDataSourceContract: RemoteDataSourceContract) :
    LandingRepositoryContract {
    override suspend fun getTest() {
        val response = remoteDataSourceContract.getTest()
        if (response.isSuccessful) {
            return response.body() as Unit
        } else {
            println("GRESKA U RESPONSE")
        }
    }

    override suspend fun registerUser(registrationRequestModel: RegistrationRequestModel): RegistrationResponseModel {
        val response = remoteDataSourceContract.registerUser(registrationRequestModel)
        return if (response.isSuccessful) {
            response.body() as RegistrationResponseModel
        } else {
            RegistrationResponseModel("Greska ${response.getErrorMessage()}")
        }
    }
}
