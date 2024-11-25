package com.online.template.features.landing.presentation.main

import dagger.assisted.AssistedFactory

@AssistedFactory
interface LandingMainViewModelFactory {
    fun create(): LandingMainViewModel
}
