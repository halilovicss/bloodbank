package com.online.template.features.donor_detail.presentation

import com.online.template.features.donor_detail.presentation.DonorDetailsViewModel
import dagger.assisted.AssistedFactory

@AssistedFactory
interface DonorDetailsViewModelFactory {
    fun create(): DonorDetailsViewModel
}
