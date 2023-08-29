package com.example.currencyconversionapp.presentation.feature.conversion

interface ConverterContract {
    fun onBaseCurrencyChanged(baseCurrency: String)
    fun onTargetCurrencyChanged(targetCurrency: String)
    fun onAmountChanged(amount: String)
    fun onConvertClicked()
}
