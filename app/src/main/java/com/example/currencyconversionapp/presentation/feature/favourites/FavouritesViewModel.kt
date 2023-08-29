package com.example.currencyconversionapp.presentation.feature.favourites

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.domain.repository.CurrencyRepository
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.data.source.remote.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val currencyRepository: CurrencyRepository):ViewModel() {
    private var list = mutableListOf<CurrencyEntity>()
    private var _favCurrenciesList: MutableStateFlow<List<CurrencyEntity>?> = MutableStateFlow(null)
    val favCurrenciesList = _favCurrenciesList
    suspend fun getCurrencies() {
        viewModelScope.launch {
            list = currencyRepository.getCurrencies().toMutableList()
            _favCurrenciesList.emit(list.toMutableList())
        }
    }
    suspend fun getCurrencyByCode(code: String) = currencyRepository.getCurrencyByCode(code)
    suspend fun insertCurrency(currencyEntity: CurrencyEntity) = currencyRepository.insertCurrency(currencyEntity)
    suspend fun deleteCurrency(code: String) = currencyRepository.deleteCurrency(code)

}