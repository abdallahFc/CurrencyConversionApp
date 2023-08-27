package com.example.currencyconversionapp.domain.repository

import com.example.currencyconversionapp.domain.model.Currency

interface CurrencyRepo {

    fun getCurrencies(): List<Currency>

    suspend fun getCurrencyByCode(code: String): Currency?

    fun insertCurrency(currency: Currency)

    fun deleteCurrency(currency: Currency)
}