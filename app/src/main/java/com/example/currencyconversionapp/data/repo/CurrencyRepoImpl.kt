package com.example.currencyconversionapp.data.repo

import com.example.currencyconversionapp.domain.model.Currency
import com.example.currencyconversionapp.data.source.local.CurrencyDao
import com.example.currencyconversionapp.domain.repository.CurrencyRepo

class CurrencyRepoImpl(
    val currencyDao: CurrencyDao
) : CurrencyRepo {
    override suspend fun getCurrencies(): List<Currency> {
        return currencyDao.getCurrencies()
    }

    override suspend fun getCurrencyByCode(code: String): Currency? {
        return currencyDao.getCurrencyByCode(code)
    }

    override suspend fun insertCurrency(currency: Currency) {
        currencyDao.insertCurrency(currency)
    }

    override suspend fun deleteCurrency(currency: Currency) {
        currencyDao.deleteCurrency(currency)
    }

}