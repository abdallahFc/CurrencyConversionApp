package com.example.currencyconversionapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.currencyconversionapp.data.source.local.CurrencyDao
import com.example.currencyconversionapp.data.source.local.CurrencyDatabase
import com.example.currencyconversionapp.data.source.remote.CurrencyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CurrencyDatabase =
        Room.databaseBuilder(context, CurrencyDatabase::class.java, "CURRENCY_DATABASE")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(currencyDatabase: CurrencyDatabase): CurrencyDao =
        currencyDatabase.currencyDao

    private const val BaseUrl = ""

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): CurrencyService =
        retrofit.create(CurrencyService::class.java)
}