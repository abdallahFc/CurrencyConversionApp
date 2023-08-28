package com.example.currencyconversionapp.domain.repository

import com.example.currencyconversionapp.domain.model.Currency

interface CurrencyRepo {

    suspend fun getCurrencies(): List<Currency>

    suspend fun getCurrencyByCode(code: String): Currency?

    suspend fun insertCurrency(currency: Currency)

    suspend fun deleteCurrency(currency: Currency)
}