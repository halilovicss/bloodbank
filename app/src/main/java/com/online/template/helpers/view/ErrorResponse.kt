package com.online.template.helpers.view

import com.google.gson.Gson
import retrofit2.Response

data class ErrorResponse(val message: String?)

// Ekstenzija za parsiranje errorBody
fun Response<*>.getErrorMessage(): String? {
    val errorBody = this.errorBody()?.string() ?: return null
    return try {
        val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
        errorResponse.message
    } catch (e: Exception) {
        null // Ako parsiranje ne uspe
    }
}
