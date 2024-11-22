package com.online.template.core.di

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.BINARY

@Qualifier
@Retention(BINARY)
annotation class LoggingInterceptor

@Qualifier
@Retention(BINARY)
annotation class AuthorizationInterceptor

@Qualifier
@Retention(BINARY)
annotation class PublicOkHttpClient

@Qualifier
@Retention(BINARY)
annotation class AuthorizedOkHttpClient

@Qualifier
@Retention(BINARY)
annotation class PublicRetrofit
