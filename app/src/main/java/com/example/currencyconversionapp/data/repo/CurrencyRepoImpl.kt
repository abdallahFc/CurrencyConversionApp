package com.example.currencyconversionapp.data.repo

import com.example.currencyconversionapp.data.source.local.Currency
import com.example.currencyconversionapp.data.source.local.CurrencyDao

class CurrencyRepoImpl(
    val currencyDao: CurrencyDao
) : CurrencyRepo {
    override fun getCurrencies(): List<Currency> {
        return currencyDao.getCurrencies()
    }

    override suspend fun getCurrencyByCode(code: String): Currency? {
        return currencyDao.getCurrencyByCode(code)
    }

    override fun insertCurrency(currency: Currency) {
        currencyDao.insertCurrency(currency)
    }

    override fun deleteCurrency(currency: Currency) {
        currencyDao.deleteCurrency(currency)
    }

}