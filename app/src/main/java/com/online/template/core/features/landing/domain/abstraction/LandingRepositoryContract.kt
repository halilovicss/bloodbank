package com.online.template.core.features.landing.domain.abstraction

interface LandingRepositoryContract {
    suspend fun getTest(): Unit
}