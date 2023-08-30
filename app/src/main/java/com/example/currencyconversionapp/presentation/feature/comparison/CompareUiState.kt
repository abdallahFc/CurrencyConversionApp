package com.example.currencyconversionapp.presentation.feature.comparison

import com.example.currencyconversionapp.presentation.feature.conversion.CurrencyCode
import com.example.currencyconversionapp.presentation.feature.conversion.CurrencyUiModel

data class CompareUiState(
    val isLoading: Boolean = false,
    val isLoadingList: Boolean = false,
    val baseCurrency: CurrencyCode = CurrencyCode.EGP,
    val targetOneCurrency: CurrencyCode = CurrencyCode.KWD,
    val targetTwoCurrency: CurrencyCode = CurrencyCode.EUR,
    val amount: Double = 1.0,
    val convertedAmountOne: String = "",
    val convertedAmountTwo: String = "",
    val currencies: List<CurrencyUiModel> = emptyList(),
    val error: String = "",
    val isError: Boolean = false,
    val isAmountError: Boolean = false,
)
