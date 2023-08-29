package com.example.currencyconversionapp.presentation.feature.comparison

interface CompareContract {
    fun onBaseCurrencyChanged(baseCurrency: String)
    fun onTargetOneCurrencyChanged(targetCurrency: String)
    fun onTargetTwoCurrencyChanged(targetCurrency: String)
    fun onAmountChanged(amount: String)
    fun onCompareClicked()
}
