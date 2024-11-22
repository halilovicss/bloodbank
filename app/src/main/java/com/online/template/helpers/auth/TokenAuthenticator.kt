package com.online.template.helpers.auth

import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

// class TokenAuthenticator @Inject constructor(private val tokenRefresher: TokenRefresher)
class TokenAuthenticator @Inject constructor() :
    Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val accessToken = getAccessToken(response) ?: return null
            return response.request.newBuilder()
                .header("AUTHORIZATION", "Bearer: token")
                .build()
        }
    }

    @Synchronized
    private fun getAccessToken(response: Response): String? {
        return updatedLocalAccessToken(response.request) ?: getNewAccessToken()
    }

    @Synchronized
    private fun updatedLocalAccessToken(request: Request): String? {
        val invalidToken = request.header("AUTHORIZATION")?.removePrefix("Bearer: ")
        // val localToken = AuthPrefsWrapper.getAccessToken()
        val localToken = "Token"
        return if (invalidToken != localToken) {
            localToken
        } else {
            null
        }
    }

    @Synchronized
    private fun getNewAccessToken(): String? {
        return runBlocking {
            "REFRESH TOKEN"
            // tokenRefresher.refreshToken()
        }
    }
}
