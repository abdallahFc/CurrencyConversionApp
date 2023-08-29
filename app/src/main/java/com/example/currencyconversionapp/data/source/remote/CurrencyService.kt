package com.example.currencyconversionapp.data.source.remote

import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyService {
    @GET("pair/{base}/{target}/{amount}")
    suspend fun convertCurrency(
        @Path("base") baseCurrency: String,
        @Path("target") targetCurrency: String,
        @Path("amount") amount: Double
    ): Response<ConvertCurrencyDto>
}
