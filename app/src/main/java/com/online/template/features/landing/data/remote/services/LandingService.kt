package com.online.template.features.landing.data.remote.services

import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.data.remote.models.RegistrationResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LandingService {
    @GET("/c/3029-d29f-4014-9fb4")
    suspend fun testRetrofit(): Response<Unit>

    @POST("/register")
    suspend fun registerUser(@Body registrationRequestModel: RegistrationRequestModel): Response<RegistrationResponseModel>
}