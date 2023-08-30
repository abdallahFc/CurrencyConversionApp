package com.example.currencyconversionapp.presentation.feature.conversion

data class ConvertUiState(
    val isLoading: Boolean = false,
    val isLoadingList: Boolean = false,
    val baseCurrency: CurrencyCode = CurrencyCode.USD,
    val targetCurrency: CurrencyCode = CurrencyCode.EGP,
    val amount: String = "1.0",
    val convertedAmount: String = "",
    val currencies: List<CurrencyUiModel> = emptyList(),
    val favCurrencies: List<CurrencyUiModel> = emptyList(),
    val isFavoriteLoading: Boolean = false,
    val error: String = "",
    val isError: Boolean = false,
    val isFavError: Boolean = false,
    val isAmountError: Boolean = false,
)

data class CurrencyUiModel(
    val code: String = "",
    val flagUrl: String = "",
    val name: String = "",
    val rate: String = ""
)

enum class CurrencyCode(val code: String) {
    JPY("JPY"),
    OMR("OMR"),
    GBP("GBP"),
    USD("USD"),
    SAR("SAR"),
    KWD("KWD"),
    EGP("EGP"),
    QAR("QAR"),
    AED("AED"),
    BHD("BHD"),
    EUR("EUR")
}
