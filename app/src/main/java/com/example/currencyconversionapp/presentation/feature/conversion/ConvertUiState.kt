package com.example.currencyconversionapp.presentation.feature.conversion

data class ConvertUiState(
    val isLoading: Boolean = false,
    val isLoadingList: Boolean = false,
    val baseCurrency: CurrencyCode = CurrencyCode.EGP,
    val targetCurrency: CurrencyCode = CurrencyCode.USD,
    val amount: Double = 1.0,
    val convertedAmount: String = "",
    val currencies: List<CurrencyUiModel> = emptyList(),
    val error: String = "",
    val isError: Boolean = false,
    val isAmountError: Boolean = false,
)

data class CurrencyUiModel(
    val code: String = "",
    val flagUrl: String = "",
    val name: String = ""
)

enum class CurrencyCode(val code: String) {
    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    AED("AED"),
    BHD("BHD"),
    JPY("JPY"),
    KWD("KWD"),
    OMR("OMR"),
    SAR("SAR"),
    EGP("EGP")
}
