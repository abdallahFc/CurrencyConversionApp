package com.example.currencyconversionapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencyconversionapp.domain.model.Currency

@Database(
    entities = [Currency::class],
    version = 1,
    exportSchema = true
)
abstract class CurrencyDatabase : RoomDatabase() {
    abstract val currencyDao : CurrencyDao

    companion object {
        const val DATABASE_NAME = "currency_db"
    }
}