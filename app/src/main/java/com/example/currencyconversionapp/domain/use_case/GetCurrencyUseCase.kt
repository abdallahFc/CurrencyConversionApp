package com.example.currencyconversionapp.domain.use_case

import com.example.currencyconversionapp.domain.model.Currency
import com.example.currencyconversionapp.domain.repository.CurrencyRepo

class GetCurrencyUseCase (
    private val repository: CurrencyRepo
) {
    suspend fun invoke(code: String) : Currency? {
        return repository.getCurrencyByCode(code)
    }
}