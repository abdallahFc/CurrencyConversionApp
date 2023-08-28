package com.example.currencyconversionapp.domain.use_case

import com.example.currencyconversionapp.domain.model.Currency
import com.example.currencyconversionapp.domain.repository.CurrencyRepo

class DeleteCurrencyUseCase (
    private val repository: CurrencyRepo
) {
    suspend operator fun invoke(code: String) {
        repository.deleteCurrency(code)
    }
}