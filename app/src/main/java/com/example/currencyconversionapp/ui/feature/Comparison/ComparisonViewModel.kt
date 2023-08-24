package com.example.currencyconversionapp.ui.feature.Comparison

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ComparisonViewModel : ViewModel() {

    private var _toCurrency1Amount = mutableStateOf("1")
    var toCurrency1Amount: MutableState<String> = _toCurrency1Amount

    private var _toCurrency2Amount = mutableStateOf("1")
    var toCurrency2Amount: MutableState<String> = _toCurrency2Amount

    private var _fromCurrencyAmount = mutableStateOf("1")
    var fromCurrencyAmount: MutableState<String> = _fromCurrencyAmount


    fun compareButtonClickable() {

    }
}