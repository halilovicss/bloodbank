package com.online.template.features.landing.data.remote.data_sources

import retrofit2.Response

interface RemoteDataSourceContract {
    suspend fun getTest(): Response<Unit>
}