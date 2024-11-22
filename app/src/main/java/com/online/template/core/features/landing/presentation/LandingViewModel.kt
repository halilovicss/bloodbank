package com.online.template.core.features.landing.presentation

import com.online.template.core.presentation.activity.CoreViewModel
import com.online.mvvmtemplate.features.landing.domain.use_case.GetTestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val getTestUseCase: GetTestUseCase
) : CoreViewModel() {

    init {
        launch { getTestUseCase.invoke() }
    }

    fun start() = launch { getTestUseCase.invoke() }
}