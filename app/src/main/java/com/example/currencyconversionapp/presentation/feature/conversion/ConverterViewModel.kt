package com.example.currencyconversionapp.presentation.feature.conversion

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ConverterViewModel : ViewModel() {

    private var _toCurrencyAmount = mutableStateOf("1")
    var toCurrencyAmount: MutableState<String> = _toCurrencyAmount

    private var _fromCurrencyAmount = mutableStateOf("1")
    var fromCurrencyAmount: MutableState<String> = _fromCurrencyAmount


    fun convertButtonClickable() {

    }
}