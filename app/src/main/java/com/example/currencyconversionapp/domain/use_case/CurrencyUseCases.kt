package com.example.currencyconversionapp.domain.use_case

data class CurrencyUseCases (
    val getCurrencies: GetCurrenciesUseCase,
    val getCurrency: GetCurrencyUseCase,
    val insertCurrency: InsertCurrencyUseCase,
    val deleteCurrency: DeleteCurrencyUseCase
)