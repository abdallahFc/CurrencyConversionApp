package com.example.currencyconversionapp.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.currencyconversionapp.domain.model.Currency

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM Image_table")
    fun getCurrencies(): List<Currency>

    @Query("SELECT * FROM Image_table WHERE code = :code")
    suspend fun getCurrencyByCode(code: String) : Currency?

    @Insert
    fun insertCurrency(currency: Currency)

    @Delete
    fun deleteCurrency(currency: Currency)

}