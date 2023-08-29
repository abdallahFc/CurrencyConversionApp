package com.example.currencyconversionapp.data.source.remote

import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CompareService {
    @GET("compare/{base}/{target}/{amount}")
    suspend fun compareCurrency(
        @Path("base") baseCurrency: String,
        @Path("target") targetCurrency: String,
        @Path("amount") amount: Double
    ): Response<List<ConvertCurrencyDto>>
}