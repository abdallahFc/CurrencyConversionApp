package com.example.currencyconversionapp.presentation.feature.conversion

import android.util.Log
import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import com.example.currencyconversionapp.data.source.remote.model.CurrencyDto
import com.example.currencyconversionapp.domain.repository.CurrencyRepository
import com.example.currencyconversionapp.presentation.base.BaseViewModel
import com.example.currencyconversionapp.presentation.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val dispatcherProvider: DispatcherProvider
) : BaseViewModel<ConvertUiState>(ConvertUiState()), ConverterContract {

    init {
        convertCurrency(
            baseCurrency = state.value.baseCurrency.name,
            targetCurrency = state.value.targetCurrency.name,
            amount = state.value.amount
        )
        getAllCurrencies()
    }

    fun convertCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double
    ) {
        _state.update { state -> state.copy(isLoading = true, isError = false) }
        tryToExecute(
            function = {
                currencyRepository.convertCurrency(baseCurrency, targetCurrency, amount)
            },
            onSuccess = ::handleConversionSuccess,
            onError = ::handleConversionError,
            dispatcher = dispatcherProvider.io
        )
    }

    private fun handleConversionSuccess(convertedAmount: ConvertCurrencyDto) {
        _state.update { state ->
            state.copy(
                isLoading = false,
                convertedAmount = convertedAmount.conversion_rate,
                isError = false
            )
        }
    }

    private fun handleConversionError(exception: Exception) {
        _state.update { state ->
            state.copy(
                isLoading = false,
                error = exception.message ?: "Something went wrong",
                isError = true
            )
        }
    }

    fun getAllCurrencies() {
        _state.update { state -> state.copy(isLoadingList = true, isError = false) }
        tryToExecute(
            function = {
                currencyRepository.getAllCurrencies()
            },
            onSuccess = ::handleGetAllCurrenciesSuccess,
            onError = ::handleGetAllCurrenciesError,
            dispatcher = dispatcherProvider.io
        )
    }
    private fun handleGetAllCurrenciesSuccess(currencies:List<CurrencyDto>) {
        _state.update { state ->
            state.copy(
                isLoadingList = false,
                currencies = currencies.map { currency ->
                    CurrencyUiModel(
                        code = currency.code,
                        flagUrl = currency.flagUrl,
                        name = currency.name
                    )
                },
                isError = false
            )
        }
    }
    private fun handleGetAllCurrenciesError(exception: Exception) {
        _state.update { state ->
            state.copy(
                isLoadingList = false,
                error = exception.message ?: "Something went wrong",
                isError = true
            )
        }
    }

    override fun onConvertClicked() {
        convertCurrency(
            state.value.baseCurrency.name,
            state.value.targetCurrency.name,
            state.value.amount
        )
    }

    override fun onBaseCurrencyChanged(baseCurrency: String) {
        _state.update { state -> state.copy(baseCurrency = CurrencyCode.valueOf(baseCurrency)) }
    }

    override fun onTargetCurrencyChanged(targetCurrency: String) {
        _state.update { state -> state.copy(targetCurrency = CurrencyCode.valueOf(targetCurrency)) }
    }

    override fun onAmountChanged(amount: String) {
        val parsedAmount = amount.toDoubleOrNull()
        if (parsedAmount != null && parsedAmount >= 0) {
            _state.update { state ->
                state.copy(amount = parsedAmount, isAmountError = false)
            }
        } else {
            _state.update { state ->
                state.copy(isAmountError = true)
            }
        }
    }

}