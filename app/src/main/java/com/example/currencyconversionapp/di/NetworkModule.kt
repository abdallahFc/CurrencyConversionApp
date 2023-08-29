package com.example.currencyconversionapp.di

import com.example.currencyconversionapp.data.source.remote.CurrenciesService
import com.example.currencyconversionapp.data.source.remote.CurrencyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://compare-test-production.up.railway.app"
    @Provides
    fun provideGithubApiService(
        @Named("CurrencyApi") currencyRetrofit: Retrofit,
    ): CurrencyService {
        return currencyRetrofit.create(CurrencyService::class.java)
    }

    @Provides
    fun provideUpdateApiService(
        @Named("UpdateApi") updateRetrofit: Retrofit,
    ): CurrenciesService {
        return updateRetrofit.create(CurrenciesService::class.java)
    }

    @Provides
    @Named("CurrencyApi")
    fun provideCurrencyRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://compare-test-production.up.railway.app")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("UpdateApi")
    fun provideUpdateRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://getupdate-production.up.railway.app")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}