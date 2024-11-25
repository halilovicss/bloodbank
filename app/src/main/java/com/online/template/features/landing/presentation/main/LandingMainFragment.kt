package com.online.template.features.landing.presentation.main

import android.content.Intent
import com.online.template.core.presentation.activity.CoreFragment
import com.online.template.core.presentation.activity.assistedViewModel
import com.online.template.databinding.FragmentLandingMainBinding
import com.online.template.features.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LandingMainFragment :
    CoreFragment<FragmentLandingMainBinding, LandingMainViewModel>(FragmentLandingMainBinding::inflate) {
    @Inject
    lateinit var factory: LandingMainViewModelFactory
    override val viewModel: LandingMainViewModel by assistedViewModel {
        factory.create()
    }

    override fun setupUI(): Unit = with(binding) {
        super.setupUI()
        this?.lifecycleOwner = viewLifecycleOwner
        this?.data = viewModel
    }

    override fun setObservers() = with(viewModel) {
        super.setObservers()
        openMain.observe(viewLifecycleOwner) {
            requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
    }
}
