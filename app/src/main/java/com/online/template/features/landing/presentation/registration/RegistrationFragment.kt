package com.online.template.features.landing.presentation.registration

import com.online.template.core.presentation.activity.CoreFragment
import com.online.template.core.presentation.activity.assistedViewModel
import com.online.template.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegistrationFragment :
    CoreFragment<FragmentRegistrationBinding, RegistrationViewModel>(FragmentRegistrationBinding::inflate) {
    @Inject
    lateinit var factory: RegistrationViewModelFactory
    override val viewModel: RegistrationViewModel by assistedViewModel {
        factory.create()
    }
}