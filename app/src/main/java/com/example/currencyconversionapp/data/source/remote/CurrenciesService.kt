package com.example.currencyconversionapp.data.source.remote

import com.example.currencyconversionapp.data.source.remote.model.CurrencyDto
import retrofit2.Response
import retrofit2.http.GET

interface CurrenciesService {
    @GET("api/currencies")
    suspend fun getCurrencies(): Response<List<CurrencyDto>>
}
