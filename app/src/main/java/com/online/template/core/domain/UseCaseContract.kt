package com.online.template.core.domain


/**
 * This interface should be implemented by every use case
 * that does not require any input parameters.
 */
interface UseCaseContract<out OutTypeT> {

    /**
     * Contains use case logic, and returns [OutTypeT].
     */
    suspend operator fun invoke(): OutTypeT
}
