package com.online.template.features.landing.presentation.registration

import dagger.assisted.AssistedFactory

@AssistedFactory
interface RegistrationViewModelFactory {
    fun create(): RegistrationViewModel
}
