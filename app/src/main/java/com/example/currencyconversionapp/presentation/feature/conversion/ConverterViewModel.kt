package com.example.currencyconversionapp.presentation.feature.conversion

import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import com.example.currencyconversionapp.data.source.remote.model.CurrencyDto
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.presentation.base.BaseViewModel
import com.example.currencyconversionapp.presentation.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val dispatcherProvider: DispatcherProvider
) : BaseViewModel<ConvertUiState>(ConvertUiState()), ConverterInteractionListener {

    init {
        convertCurrency(
            baseCurrency = state.value.baseCurrency.name,
            targetCurrency = state.value.targetCurrency.name,
            amount = state.value.amount.toDoubleOrNull()
        )
        getAllCurrencies()
        getAllFavCurrencies()
    }

    fun convertCurrency(
        baseCurrency: String,
        targetCurrency: String,
        amount: Double?
    ) {
        if (amount != null && amount >= 0) {
            _state.update { state -> state.copy(isLoading = true, isError = false) }
            tryToExecute(
                function = {
                    currencyRepository.convertCurrency(baseCurrency, targetCurrency, amount)
                },
                onSuccess = ::handleConversionSuccess,
                onError = ::handleConversionError,
                dispatcher = dispatcherProvider.io
            )

        } else {
            _state.update { state -> state.copy(isAmountError = true) }
        }
    }

    private fun handleConversionSuccess(convertedAmount: ConvertCurrencyDto) {
        val decimalFormat = DecimalFormat("#.##")
        val formattedAmount = decimalFormat.format(convertedAmount.conversion_rate.toDouble())
        _state.update { state ->
            state.copy(
                isLoading = false,
                convertedAmount = formattedAmount,
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

     fun getAllFavCurrencies() {
        viewModelScope.launch {
            val favList = currencyRepository.getCurrencies()
            if (favList.isEmpty()) {
                _state.update { state ->
                    state.copy(isFavoriteLoading = false, isError = false,
                        favCurrencies = emptyList())
                }
                return@launch
            }
            val currencyCodes = favList.joinToString(",") { currency ->
                currency.code
            }
            _state.update { state ->
                state.copy(isFavoriteLoading = true, isError = false,
                    favCurrencies = favList.map {
                        CurrencyUiModel(
                            code = it.code,
                            flagUrl = it.flag,
                            name = it.name
                        )
                    })
            }

            tryToExecute(
                function = {
                    currencyRepository.compareCurrency(
                        baseCurrency = state.value.baseCurrency.name,
                        targetCurrency = currencyCodes.toString(),
                        amount = 1.0
                    )
                },
                onSuccess = ::handleGetAllFavCurrenciesSuccess,
                onError = ::handleGetAllFavCurrenciesError,
                dispatcher = dispatcherProvider.io
            )
        }
    }

    private fun handleGetAllFavCurrenciesSuccess(convertedAmount: List<ConvertCurrencyDto>) {
        _state.update { state ->
            state.copy(
                isFavoriteLoading = false,
                favCurrencies = state.favCurrencies.mapIndexed { index, currencyUiModel ->
                    val decimalFormat = DecimalFormat("#.##")
                    val formattedAmount = decimalFormat.format(convertedAmount[index].conversion_rate.toDouble())
                    currencyUiModel.copy(rate =formattedAmount)
                },
                isFavError = false
            )
        }
    }

    private fun handleGetAllFavCurrenciesError(exception: Exception) {
        _state.update { state ->
            state.copy(
                isFavoriteLoading = false,
                isFavError = true
            )
        }
    }

    override fun onConvertClicked() {
        convertCurrency(
            state.value.baseCurrency.name,
            state.value.targetCurrency.name, state.value.amount.toDoubleOrNull()
        )
        getAllFavCurrencies()

    }

    override fun onBaseCurrencyChanged(baseCurrency: String) {
        _state.update { state -> state.copy(baseCurrency = CurrencyCode.valueOf(baseCurrency)) }
    }

    override fun onTargetCurrencyChanged(targetCurrency: String) {
        _state.update { state -> state.copy(targetCurrency = CurrencyCode.valueOf(targetCurrency)) }
    }

    override fun onAmountChanged(amount: String) {

            _state.update { state ->
                state.copy(amount = amount, isAmountError = false)
            }
    }

}