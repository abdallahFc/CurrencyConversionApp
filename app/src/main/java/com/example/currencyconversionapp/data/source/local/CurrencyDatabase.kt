package com.example.currencyconversionapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = 1,
    exportSchema = true
)
abstract class CurrencyDatabase : RoomDatabase() {
    abstract val currencyDao : CurrencyDao
}