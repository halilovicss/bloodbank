package com.online.template.features.donor_detail.presentation

import com.online.template.core.presentation.activity.CoreFragment
import com.online.template.core.presentation.activity.assistedViewModel
import com.online.template.databinding.FragmentDonorDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DonorDetailsFragment :
    CoreFragment<FragmentDonorDetailsBinding, DonorDetailsViewModel>(FragmentDonorDetailsBinding::inflate) {
    @Inject
    lateinit var factory: DonorDetailsViewModelFactory
    override val viewModel: DonorDetailsViewModel by assistedViewModel {
        factory.create()
    }

    override fun setupUI(): Unit = with(binding) {
        super.setupUI()
        this?.lifecycleOwner = viewLifecycleOwner
        this?.data = viewModel
    }

    override fun setObservers() {
        super.setObservers()
    }
}