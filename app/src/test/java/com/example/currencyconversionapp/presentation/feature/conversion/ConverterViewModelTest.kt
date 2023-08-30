package com.example.currencyconversionapp.presentation.feature.conversion

import app.cash.turbine.test
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.data.source.remote.model.ConvertCurrencyDto
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.presentation.feature.util.MainCoroutineRule
import com.example.currencyconversionapp.presentation.feature.util.TestDispatchers
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ConverterViewModelTest {
    private lateinit var mockRepository: CurrencyRepository
    private lateinit var viewModel: ConverterViewModel
    private lateinit var testDispatcher: TestDispatchers

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setUp() {
        testDispatcher = TestDispatchers()
        mockRepository = mockk(relaxed = true)
        viewModel = ConverterViewModel(mockRepository, testDispatcher)
    }

    @Test
    fun `getAllCurrencies() when unsuccessful call, then should return error`() =
        runTest {
            // Given
            val error = "error"
            coEvery { mockRepository.getAllCurrencies() } throws Exception(error)
            // When
            viewModel.getAllCurrencies()

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(true, awaitItem().isError)
            }
        }

    @Test
    fun `getAllCurrencies() when server error, then should return error state`() =
        runTest {
            // Given
            val error = "server error"
            coEvery { mockRepository.getAllCurrencies() } throws Exception(error)
            // When
            viewModel.getAllCurrencies()

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(true, awaitItem().isError)
            }
        }

    @Test
    fun `getAllCurrencies() when successful call, then should return success state`() =
        runTest {
            // Given
            val currencies = listOf(
                CurrencyEntity(
                    code = "USD",
                    flag = "https://www.countryflags.io/us/flat/64.png",
                    name = "United States Dollar"
                ),
                CurrencyEntity(
                    code = "USD",
                    flag = "https://www.countryflags.io/us/flat/64.png",
                    name = "United States Dollar"
                ),
            )
            coEvery { mockRepository.getCurrencies() } returns currencies
            // When
            viewModel.getAllCurrencies()

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(false, awaitItem().isError)
            }
        }

    @Test
    fun `convertCurrency() when unsuccessful call, then should return error`() =
        runTest {
            // Given
            val error = "error"
            coEvery { mockRepository.convertCurrency(any(), any(), any()) } throws Exception(error)
            // When
            viewModel.convertCurrency("USD", "USD", 1.0)

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(true, awaitItem().isError)
            }
        }

    @Test
    fun `convertCurrency() when server error, then should return error state`() =
        runTest {
            // Given
            val error = "server error"
            coEvery { mockRepository.convertCurrency(any(), any(), any()) } throws Exception(error)
            // When
            viewModel.convertCurrency("USD", "USD", 1.0)

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(true, awaitItem().isError)
            }
        }

    @Test
    fun `convertCurrency() when successful call, then should return success state`() =
        runTest {
            // Given
            val currency = ConvertCurrencyDto(
                amount = "1.0",
                base_code = "USD",
                conversion_rate = "1.0",
                target_code = "USD"
            )
            coEvery {
                mockRepository.convertCurrency(
                    currency.base_code,
                    currency.target_code,
                    currency.amount.toDouble()
                )
            } returns currency
            // When
            viewModel.convertCurrency("USD", "USD", 1.0)

            delay(10L)
            // Then
            viewModel.state.test {
                val newState = awaitItem()
                assertFalse(newState.isError)
                assertEquals("1", newState.convertedAmount)
            }
        }

    @Test
    fun `onBaseCurrencyChanged() should update base currency in state`() =
        runTest {
            // When
            viewModel.onBaseCurrencyChanged("USD")

            // Then
            viewModel.state.test {
                val newState = awaitItem()
                assertEquals("USD", newState.baseCurrency.name)
            }
        }

    @Test
    fun `onTargetCurrencyChanged() should update target currency in state`() =
        runTest {
            // When
            viewModel.onTargetCurrencyChanged("EUR")

            // Then
            viewModel.state.test {
                val newState = awaitItem()
                assertEquals("EUR", newState.targetCurrency.name)
            }
        }

    @Test
    fun `onAmountChanged() when valid amount, should update amount in state`() =
        runTest {
            // When
            viewModel.onAmountChanged("100")

            // Then
            viewModel.state.test {
                val newState = awaitItem()
                assertFalse(newState.isAmountError)
            }
        }


}