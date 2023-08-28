package com.example.currencyconversionapp.di

import android.app.Application
import androidx.room.Room
import com.example.currencyconversionapp.domain.repository.CurrencyRepo
import com.example.currencyconversionapp.data.repo.CurrencyRepoImpl
import com.example.currencyconversionapp.data.source.local.CurrencyDatabase
import com.example.currencyconversionapp.domain.use_case.CurrencyUseCases
import com.example.currencyconversionapp.domain.use_case.DeleteCurrencyUseCase
import com.example.currencyconversionapp.domain.use_case.GetCurrenciesUseCase
import com.example.currencyconversionapp.domain.use_case.GetCurrencyUseCase
import com.example.currencyconversionapp.domain.use_case.InsertCurrencyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//    @Provides
//    @Singleton
//    fun provideNoteDatabase(app: Application): CurrencyDatabase {
//        return Room.databaseBuilder(
//            app,
//            CurrencyDatabase::class.java,
//            CurrencyDatabase.DATABASE_NAME,
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideNoteRepository(db: CurrencyDatabase): CurrencyRepo {
//        return CurrencyRepoImpl(db.currencyDao)
//    }
//
//    @Provides
//    @Singleton
//    fun provideNoteUseCases(repository: CurrencyRepo) : CurrencyUseCases {
//        return CurrencyUseCases(
//            getCurrencies = GetCurrenciesUseCase(repository),
//            getCurrency = GetCurrencyUseCase(repository),
//            insertCurrency = InsertCurrencyUseCase(repository),
//            deleteCurrency = DeleteCurrencyUseCase(repository)
//        )
//    }
}