package com.online.template.features.landing.presentation.registration

import androidx.lifecycle.MutableLiveData
import com.online.template.core.presentation.activity.CoreViewModel
import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.domain.use_case.RegisterUserUseCase
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class RegistrationViewModel @AssistedInject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : CoreViewModel() {
    val name = MutableLiveData<String?>()
    val email = MutableLiveData<String?>()
    val password = MutableLiveData<String?>()
    val responseData = MutableLiveData<String?>()
    val progressBar = MutableStateFlow(false)

    fun registerUser() {
        launch {
            progressBar.emit(true)
            val response =
                registerUserUseCase.invoke(
                    RegistrationRequestModel(
                        name.value,
                        email.value,
                        password.value
                    )
                )
            progressBar.emit(false)
            responseData.postValue(response.message)
        }
    }
}