package com.online.template.features.landing.presentation.main

import com.online.template.core.presentation.activity.CoreViewModel
import com.online.template.helpers.coroutines.SingleLiveEvent
import dagger.assisted.AssistedInject

class LandingMainViewModel @AssistedInject constructor() : CoreViewModel() {
    val openMain = SingleLiveEvent<Boolean>()
    fun openRegistration() {
        navigate(LandingMainFragmentDirections.actionLandingMainFragmentToRegistrationFragment())
    }

    fun openMainScreen() = openMain.postValue(true)
}
