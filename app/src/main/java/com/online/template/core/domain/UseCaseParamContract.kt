package com.online.template.core.domain

interface UseCaseParamContract<InTypeT, OutTypeT> {

    /**
     * Contains use case logic, and returns [OutTypeT].
     */
    suspend operator fun invoke(data: InTypeT): OutTypeT
}
