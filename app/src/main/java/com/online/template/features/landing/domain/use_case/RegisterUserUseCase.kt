package com.online.template.features.landing.domain.use_case

import com.online.template.core.domain.UseCaseContract
import com.online.template.core.domain.UseCaseParamContract
import com.online.template.features.landing.data.remote.models.RegistrationRequestModel
import com.online.template.features.landing.data.remote.models.RegistrationResponseModel
import com.online.template.features.landing.domain.abstraction.LandingRepositoryContract
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repository: LandingRepositoryContract
) : UseCaseParamContract<RegistrationRequestModel, RegistrationResponseModel> {
    override suspend fun invoke(data: RegistrationRequestModel): RegistrationResponseModel {
        return repository.registerUser(data)
    }
}