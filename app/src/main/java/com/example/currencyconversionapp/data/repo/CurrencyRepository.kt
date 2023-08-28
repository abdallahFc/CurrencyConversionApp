package com.example.currencyconversionapp.data.repo

import com.example.currencyconversionapp.data.source.local.Currency
import com.example.currencyconversionapp.data.source.local.CurrencyDao
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val dao: CurrencyDao) {
    suspend fun getCurrencies() = dao.getCurrencies()
    suspend fun getCurrencyByCode(code: String) = dao.getCurrencyByCode(code)
    suspend fun insertCurrency(currency: Currency) = dao.insertCurrency(currency)
    suspend fun deleteCurrency(currency: Currency) = dao.deleteCurrency(currency)
}