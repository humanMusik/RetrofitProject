package com.example.retrofitproject.di

import com.example.retrofitproject.data.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val USER_SERVICE_BASE_URL = "https://api.github.com"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @UserOkHttp3ClientQualifier
    @Singleton
    @Provides
    fun provideUserOkHttpClient(): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)
        )
        .connectTimeout(10000L, TimeUnit.MILLISECONDS)
        .readTimeout(10000L, TimeUnit.MILLISECONDS)
        .writeTimeout(10000L, TimeUnit.MILLISECONDS)
        .build()

    @Singleton
    @Provides
    fun provideUserService(
        @UserOkHttp3ClientQualifier client: OkHttpClient,
    ): UserService =
        Retrofit
            .Builder()
            .baseUrl(USER_SERVICE_BASE_URL)
            .client(client)
            .build()
            .create(UserService::class.java)
}
