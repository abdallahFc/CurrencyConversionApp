package com.example.currencyconversionapp.domain.repository

import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import com.example.currencyconversionapp.data.source.remote.model.CurrencyDto

interface CurrencyRepository {
    suspend fun getCurrencies(): List<CurrencyEntity>
    suspend fun getCurrencyByCode(code: String): CurrencyEntity?
    suspend fun insertCurrency(currencyEntity: CurrencyEntity)
    suspend fun deleteCurrency(code: String)

    suspend fun getAllCurrencies(): List<CurrencyDto>
    suspend fun convertCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double
    ): ConvertCurrencyDto
    fun setDarkMode(isDark: Boolean)
    fun isDark() : Boolean

    suspend fun compareCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double
    ): List<ConvertCurrencyDto>
}
