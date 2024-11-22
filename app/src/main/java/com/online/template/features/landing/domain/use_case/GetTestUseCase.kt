package com.online.mvvmtemplate.features.landing.domain.use_case

import com.online.template.core.domain.UseCaseContract
import com.online.template.features.landing.domain.abstraction.LandingRepositoryContract
import javax.inject.Inject

class GetTestUseCase @Inject constructor(
    private val repositoryContract: LandingRepositoryContract
) : UseCaseContract<Unit> {
    override suspend fun invoke() {
        return repositoryContract.getTest()
    }
}