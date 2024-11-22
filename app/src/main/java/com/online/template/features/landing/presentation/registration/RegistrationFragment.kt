package com.online.template.features.landing.presentation.registration

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.online.template.core.presentation.activity.CoreFragment
import com.online.template.core.presentation.activity.assistedViewModel
import com.online.template.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@AndroidEntryPoint
class RegistrationFragment :
    CoreFragment<FragmentRegistrationBinding, RegistrationViewModel>(FragmentRegistrationBinding::inflate) {
    @Inject
    lateinit var factory: RegistrationViewModelFactory
    override val viewModel: RegistrationViewModel by assistedViewModel {
        factory.create()
    }

    override fun setupUI(): Unit = with(binding) {
        super.setupUI()
        this?.let {
            lifecycleOwner = viewLifecycleOwner
            data = viewModel
        }
    }

    override fun setObservers() {
        super.setObservers()
        lifecycleScope.launch {
            viewModel.progressBar.collect { isLoading ->
                println("UCITAVANJE $isLoading")
            }
        }
        viewModel.responseData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
        }
    }
}
