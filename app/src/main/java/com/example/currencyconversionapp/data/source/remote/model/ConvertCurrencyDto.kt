package com.example.currencyconversionapp.data.source.remote.model

data class ConvertCurrencyDto(
    val amount: String,
    val base_code: String,
    val conversion_rate: String,
    val target_code: String
)