package com.online.template.core.presentation.activity

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.online.template.helpers.coroutines.SingleLiveEvent
import com.online.template.helpers.navigation.NavigationCommand
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Core viewModel class for v2 version of beatport mobile app following MVVM principles
 */
abstract class CoreViewModel : ViewModel(), LifecycleObserver {

    private val _navigationCommands = SingleLiveEvent<NavigationCommand>()
    val navigationCommands: LiveData<NavigationCommand>
        get() = _navigationCommands

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
    protected fun navigate(directions: NavDirections) {
        _navigationCommands.postValue(NavigationCommand.To(directions))
    }
    protected fun navigate(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.To -> _navigationCommands.postValue(NavigationCommand.To(navCommand.directions))
            is NavigationCommand.BackTo -> _navigationCommands.postValue(
                NavigationCommand.BackTo(
                    navCommand.directions
                )
            )
            else -> _navigationCommands.postValue(navCommand)
        }
    }

}
