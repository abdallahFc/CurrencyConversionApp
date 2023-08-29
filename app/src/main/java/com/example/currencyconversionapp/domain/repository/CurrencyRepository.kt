package com.example.currencyconversionapp.domain.repository

import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto

interface CurrencyRepository {
    suspend fun getCurrencies(): List<CurrencyEntity>
    suspend fun getCurrencyByCode(code: String): CurrencyEntity?
    suspend fun insertCurrency(currencyEntity: CurrencyEntity)
    suspend fun deleteCurrency(code: String)
    suspend fun convertCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double
    ): ConvertCurrencyDto
}
