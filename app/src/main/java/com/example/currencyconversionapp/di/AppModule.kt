package com.example.currencyconversionapp.di

import com.example.currencyconversionapp.presentation.util.DispatcherProvider
import com.example.currencyconversionapp.presentation.util.StandardDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStandardProvider(): DispatcherProvider {
        return StandardDispatcher()
    }
}