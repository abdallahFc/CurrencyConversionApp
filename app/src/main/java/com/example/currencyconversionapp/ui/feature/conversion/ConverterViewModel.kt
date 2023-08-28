package com.example.currencyconversionapp.ui.feature.conversion

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.data.source.local.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(private val currencyRepository: CurrencyRepository) :
    ViewModel() {

    private var _toCurrencyAmount = mutableStateOf("1")
    var toCurrencyAmount: MutableState<String> = _toCurrencyAmount

    private var _fromCurrencyAmount = mutableStateOf("1")
    var fromCurrencyAmount: MutableState<String> = _fromCurrencyAmount

    private var list = mutableListOf<Currency>()
    private var _favCurrenciesList: MutableStateFlow<List<Currency>?> = MutableStateFlow(null)
    val favCurrenciesList = _favCurrenciesList

    suspend fun getCurrencies() {
        viewModelScope.launch {
            list = currencyRepository.getCurrencies().toMutableList()
            _favCurrenciesList.emit(list.toMutableList())
        }
    }


    fun convertButtonClickable() {

    }
}