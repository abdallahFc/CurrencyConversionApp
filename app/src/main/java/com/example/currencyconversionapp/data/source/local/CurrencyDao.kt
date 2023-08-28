package com.example.currencyconversionapp.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM CURRENCY_TABLE")
    suspend fun getCurrencies(): List<Currency>

    @Query("SELECT * FROM CURRENCY_TABLE WHERE code = :code")
    suspend fun getCurrencyByCode(code: String): Currency?

    @Insert
    suspend fun insertCurrency(currency: Currency)

    @Delete
    suspend fun deleteCurrency(currency: Currency)

}