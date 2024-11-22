package com.online.template.features.landing.presentation.registration

import com.online.template.features.landing.presentation.registration.RegistrationViewModel
import dagger.assisted.AssistedFactory

@AssistedFactory
interface RegistrationViewModelFactory {
    fun create(): RegistrationViewModel
}
