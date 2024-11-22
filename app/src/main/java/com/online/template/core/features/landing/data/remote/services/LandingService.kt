package com.online.template.core.features.landing.data.remote.services

import retrofit2.Response
import retrofit2.http.GET

interface LandingService {
    @GET("/c/3029-d29f-4014-9fb4")
    suspend fun testRetrofit(): Response<Unit>
}