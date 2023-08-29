package com.example.currencyconversionapp.di

import com.example.currencyconversionapp.data.source.remote.CurrencyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://compare-test-production.up.railway.app"
    @Provides
    fun provideGithubApiService(
        retrofit: Retrofit
    ): CurrencyService {
        return retrofit.create(CurrencyService::class.java)
    }

    @Provides
    fun retrofitBuilder(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

    }
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}