package com.example.currencyconversionapp.data.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM CURRENCY_TABLE")
    suspend fun getCurrencies(): List<CurrencyEntity>

    @Query("SELECT * FROM CURRENCY_TABLE WHERE code = :code")
    suspend fun getCurrencyByCode(code: String): CurrencyEntity?

    @Upsert
    suspend fun insertCurrency(currencyEntity: CurrencyEntity)

    @Query("DELETE FROM CURRENCY_TABLE WHERE code = :code")
    suspend fun deleteCurrency(code:String)

}