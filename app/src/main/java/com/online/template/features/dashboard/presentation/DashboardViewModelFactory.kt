package com.online.template.features.dashboard.presentation

import dagger.assisted.AssistedFactory

@AssistedFactory
interface DashboardViewModelFactory {
    fun create(): DashboardViewModel
}