package com.online.template.core.di

import com.online.template.helpers.auth.TokenAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkHttpClientModule {

    @PublicOkHttpClient
    @Singleton
    @Provides
    fun providesPublicOkHttpClient(
        @LoggingInterceptor httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
//        if (BuildConfig.DEBUG) {
//            builder.addInterceptor(httpLoggingInterceptor)
//        }
        builder.addInterceptor(httpLoggingInterceptor)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.readTimeout(60, TimeUnit.SECONDS)
        return builder.build()
    }

    @AuthorizedOkHttpClient
    @Singleton
    @Provides
    fun providesAuthorizedOkHttpClient(
        @LoggingInterceptor httpLoggingInterceptor: HttpLoggingInterceptor,
        @AuthorizationInterceptor authorizationInterceptor: Interceptor,
        authenticator: TokenAuthenticator
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
//            if (BuildConfig.DEBUG) {
//                addInterceptor(httpLoggingInterceptor)
//                addInterceptor(authorizationInterceptor)
//            }
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(authorizationInterceptor)
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            // authenticator(authenticator)
        }.build()
    }
}

