package com.example.currencyconversionapp.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.currencyconversionapp.domain.model.Currency

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM CURRENCY_TABLE")
    suspend fun getCurrencies(): List<Currency>

    @Query("SELECT * FROM CURRENCY_TABLE WHERE code = :code")
    suspend fun getCurrencyByCode(code: String): Currency?

    @Upsert
    suspend fun insertCurrency(currency: Currency)

    @Query("DELETE FROM CURRENCY_TABLE WHERE code = :code")
    suspend fun deleteCurrency(code:String)

}