package com.example.currencyconversionapp.di

import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.data.repo.CurrencyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindGithubRepository(repository: CurrencyRepositoryImpl): CurrencyRepository
}