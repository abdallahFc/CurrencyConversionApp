package com.example.currencyconversionapp.ui.feature.favourites

import androidx.lifecycle.ViewModel
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.data.source.local.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val currencyRepository: CurrencyRepository):ViewModel() {
    suspend fun getCurrencies() = currencyRepository.getCurrencies()
    suspend fun getCurrencyByCode(code: String) = currencyRepository.getCurrencyByCode(code)
    suspend fun insertCurrency(currency: Currency) = currencyRepository.insertCurrency(currency)
    suspend fun deleteCurrency(currency: Currency) = currencyRepository.deleteCurrency(currency)

}