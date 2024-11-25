package com.online.template.features.dashboard.presentation

import androidx.lifecycle.lifecycleScope
import com.online.template.core.presentation.activity.CoreFragment
import com.online.template.core.presentation.activity.assistedViewModel
import com.online.template.databinding.FragmentDashboardBinding
import com.online.template.features.dashboard.presentation.adapter.DashBoardMainAdapter
import com.online.template.features.dashboard.presentation.adapter.DashboardAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment :
    CoreFragment<FragmentDashboardBinding, DashboardViewModel>(FragmentDashboardBinding::inflate) {
    @Inject
    lateinit var factory: DashboardViewModelFactory
    override val viewModel: DashboardViewModel by assistedViewModel {
        factory.create()
    }
    private val dashboardAdapter = DashboardAdapter()
    private val dashBoardMainAdapter = DashBoardMainAdapter()
    override fun setupUI(): Unit = with(binding) {
        super.setupUI()
        this?.lifecycleOwner = viewLifecycleOwner
        this?.data = viewModel
        binding?.recyclerViewDashboard?.adapter = dashboardAdapter
        binding?.recyclerViewLinear?.apply {
            adapter = dashBoardMainAdapter
        }
    }

    override fun setObservers(): Unit = with(viewModel) {
        super.setObservers()
        lifecycleScope.launch(Dispatchers.IO) {
            menuItems.collect {
                withContext(Dispatchers.Main) {
                    dashboardAdapter.setList(it)
                }
            }
        }
        lifecycleScope.launch(Dispatchers.IO) {
            dashboardItems.collect {
                withContext(Dispatchers.Main) {
                    dashBoardMainAdapter.setItems(it)
                }
            }
        }
    }
}