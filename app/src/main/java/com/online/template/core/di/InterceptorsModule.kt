package com.online.template.core.di

import com.online.template.core.di.AuthorizationInterceptor
import com.online.template.core.di.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object InterceptorsModule {

    @LoggingInterceptor
    @Provides
    fun providesLoggingInterceptor() =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @AuthorizationInterceptor
    @Provides
    fun providesAuthorizationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                // .addHeader(AUTHORIZATION, "$BEARER ${AuthPrefsWrapper.getAccessToken()}")
                .addHeader("AUTHORIZATION", "BEARER: token")
                .build()
            chain.proceed(request)
        }
    }
}

