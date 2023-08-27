package com.example.currencyconversionapp.data.repo

import com.example.currencyconversionapp.domain.model.Currency
import com.example.currencyconversionapp.data.source.local.CurrencyDao
import com.example.currencyconversionapp.domain.repository.CurrencyRepo

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