package com.example.currencyconversionapp.data.repo

import com.example.currencyconversionapp.data.source.local.CurrencyDao
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.data.source.remote.CurrenciesService
import com.example.currencyconversionapp.data.source.remote.CurrencyService
import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import com.example.currencyconversionapp.data.source.remote.model.CurrencyDto
import com.example.currencyconversionapp.domain.repository.CurrencyRepository
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyApiService: CurrencyService,
    private val currenciesApiService: CurrenciesService,
    private val dao: CurrencyDao
) : CurrencyRepository {
    override suspend fun getCurrencies() = dao.getCurrencies()
    override suspend fun getCurrencyByCode(code: String) = dao.getCurrencyByCode(code)
    override suspend fun insertCurrency(currencyEntity: CurrencyEntity) = dao.insertCurrency(currencyEntity)
    override suspend fun deleteCurrency(code: String) = dao.deleteCurrency(code)
    override suspend fun getAllCurrencies(): List<CurrencyDto> {
        return wrapResponse {
            currenciesApiService.getCurrencies()
        }
    }

    override suspend fun convertCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double
    ): ConvertCurrencyDto {
        return wrapResponse {
            currencyApiService.convertCurrency(baseCurrency, targetCurrency, amount)
        }
    }

    private inline fun <reified T> wrapResponse(
        function: () -> Response<T>
    ): T {
        try {
            val response = function()
            if (response.isSuccessful) {
                val baseResponse = response.body()
                return baseResponse ?: throw Exception("Response body is null")
            } else {
                val errorBody = response.errorBody()?.string()
                if (errorBody != null) {
                    throw Exception(errorBody)
                } else {
                    throw Exception("Error body is null")
                }
            }
        } catch (e: IOException) {
            throw Exception("Network error")
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}
