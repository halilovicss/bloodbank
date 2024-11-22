package com.online.template.features.landing.presentation.main

import com.online.template.core.presentation.activity.CoreFragment
import com.online.template.core.presentation.activity.assistedViewModel
import com.online.template.databinding.FragmentLandingMainBinding
import javax.inject.Inject

class LandingMainFragment: CoreFragment<FragmentLandingMainBinding, LandingMainViewModel>(FragmentLandingMainBinding::inflate) {
    @Inject lateinit var factory: LandingMainViewModelFactory
    override val viewModel: LandingMainViewModel by assistedViewModel {
        factory.create()
    }
}