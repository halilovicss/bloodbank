package com.online.template.core.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.online.template.helpers.navigation.NavigationCommand
import com.online.template.helpers.view.navigate

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class CoreFragment<VB : ViewBinding, VM : CoreViewModel>(private val inflate: Inflate<VB>) :
    Fragment() {
    var binding: VB? = null
    protected abstract val viewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setObservers()
    }

    protected open fun setupUI() = Unit

    protected open fun setObservers() {
        viewModel.navigationCommands.observe(viewLifecycleOwner) {
            when (it) {
                is NavigationCommand.To -> navigate(it.directions)
                is NavigationCommand.Back -> findNavController().navigateUp()
                else -> {}
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
