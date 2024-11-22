package com.online.template.core.presentation.activity

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Core viewModel class for v2 version of beatport mobile app following MVVM principles
 */
abstract class CoreViewModel : ViewModel(), LifecycleObserver {

    /**
     * Ensures all started coroutines are canceled.
     * Make sure to call super due to this!
     */
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    /**
     * launch method to be used in child viewModels
     * can be overwritten
     */
    protected fun launch(
        coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch(coroutineDispatcher) {
            try {
                block()
            } catch (exception: Exception) {
                throw exception
            }
        }
    }

    /**
     * default error handler which will be observed by CoreFragment
     */
}
