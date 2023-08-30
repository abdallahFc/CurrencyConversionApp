package com.example.currencyconversionapp.presentation.feature.comparison

import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import com.example.currencyconversionapp.data.source.remote.model.CurrencyDto
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.presentation.base.BaseViewModel
import com.example.currencyconversionapp.presentation.feature.conversion.CurrencyCode
import com.example.currencyconversionapp.presentation.feature.conversion.CurrencyUiModel
import com.example.currencyconversionapp.presentation.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class ComparisonViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val dispatcherProvider: DispatcherProvider
) : BaseViewModel<CompareUiState>(CompareUiState()), CompareInteractionListener {

    init {
        compareCurrency(
            baseCurrency = state.value.baseCurrency.name,
            targetCurrency = state.value.targetOneCurrency.name + "," + state.value.targetTwoCurrency.name,
            amount = state.value.amount
        )
        getAllCurrencies()
    }

    fun compareCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double
    ) {
        _state.update { state -> state.copy(isLoading = true, isError = false) }
        tryToExecute(
            function = {
                currencyRepository.compareCurrency(baseCurrency, targetCurrency, amount)
            },
            onSuccess = ::handleConversionSuccess,
            onError = ::handleConversionError,
            dispatcher = dispatcherProvider.io
        )
    }

    private fun handleConversionSuccess(convertedAmount: List<ConvertCurrencyDto>) {
        val decimalFormat = DecimalFormat("#.##")

        val formattedAmountOne = decimalFormat.format(convertedAmount[0].conversion_rate.toDouble())
        val formattedAmountTwo = decimalFormat.format(convertedAmount[1].conversion_rate.toDouble())

        _state.update { state ->
            state.copy(
                isLoading = false,
                convertedAmountOne = formattedAmountOne,
                convertedAmountTwo = formattedAmountTwo,
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

    private fun handleGetAllCurrenciesSuccess(currencies: List<CurrencyDto>) {
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

    override fun onCompareClicked() {
        compareCurrency(
            state.value.baseCurrency.name,
            state.value.targetOneCurrency.name + "," + state.value.targetTwoCurrency.name,
            state.value.amount
        )
    }

    override fun onBaseCurrencyChanged(baseCurrency: String) {
        _state.update { state -> state.copy(baseCurrency = CurrencyCode.valueOf(baseCurrency)) }
    }

    override fun onTargetOneCurrencyChanged(targetCurrency: String) {
        _state.update { state -> state.copy(targetOneCurrency = CurrencyCode.valueOf(targetCurrency)) }
    }

    override fun onTargetTwoCurrencyChanged(targetCurrency: String) {
        _state.update { state -> state.copy(targetTwoCurrency = CurrencyCode.valueOf(targetCurrency)) }
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
