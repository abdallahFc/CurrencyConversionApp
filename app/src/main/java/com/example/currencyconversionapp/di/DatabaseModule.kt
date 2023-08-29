package com.example.currencyconversionapp.di

import android.content.Context
import androidx.room.Room
import com.example.currencyconversionapp.data.source.local.CurrencyDao
import com.example.currencyconversionapp.data.source.local.CurrencyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun providesRoomDatabase(
        @ApplicationContext context: Context,
    ): CurrencyDatabase {
        return Room.databaseBuilder(context, CurrencyDatabase::class.java, "GithubDatabase")
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: CurrencyDatabase): CurrencyDao {
        return database.currencyDao
    }

}