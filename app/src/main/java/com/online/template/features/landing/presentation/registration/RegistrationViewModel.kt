package com.online.template.features.landing.presentation.registration

import androidx.lifecycle.MutableLiveData
import com.online.template.core.presentation.activity.CoreViewModel
import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.domain.use_case.RegisterUserUseCase
import com.online.template.helpers.navigation.NavigationCommand
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow

class RegistrationViewModel @AssistedInject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : CoreViewModel() {
    val name = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val password = MutableStateFlow<String?>(null)
    val confirmPassword = MutableStateFlow<String?>(null)
    val responseData = MutableLiveData<String?>()
    val progressBar = MutableStateFlow(false)

    fun registerUser() {
        launch {
            if (!isFieldFilled()) return@launch
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

    fun back() = navigate(NavigationCommand.Back)
    private fun isFieldFilled(): Boolean {
        when {
            name.value.isNullOrEmpty() -> {
                responseData.postValue("Ime i Prezime je obavezno")
                return false
            }

            email.value.isNullOrEmpty() -> {
                responseData.postValue("Email je obavezno")
                return false
            }

            password.value.isNullOrEmpty() -> {
                responseData.postValue("Password je obavezno")
                return false
            }

            confirmPassword.value.isNullOrEmpty() -> {
                responseData.postValue("Potvrda sifre je obavezno")
                return false
            }
            password.value != confirmPassword.value -> {
                responseData.postValue("Sifre nisu iste")
                return false
            }

            else -> return true
        }
    }
}
