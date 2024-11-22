package com.online.template.features.landing.domain.abstraction

interface LandingRepositoryContract {
    suspend fun getTest(): Unit
}