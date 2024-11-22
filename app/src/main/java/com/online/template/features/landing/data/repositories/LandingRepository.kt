package com.online.template.features.landing.data.repositories

import com.online.template.features.landing.data.remote.data_sources.RemoteDataSourceContract
import com.online.template.features.landing.domain.abstraction.LandingRepositoryContract
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
}