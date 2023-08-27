package com.example.currencyconversionapp.data.repo

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.currencyconversionapp.data.source.local.Currency

interface CurrencyRepo {

    fun getCurrencies(): List<Currency>

    suspend fun getCurrencyByCode(code: String): Currency?

    fun insertCurrency(currency: Currency)

    fun deleteCurrency(currency: Currency)
}