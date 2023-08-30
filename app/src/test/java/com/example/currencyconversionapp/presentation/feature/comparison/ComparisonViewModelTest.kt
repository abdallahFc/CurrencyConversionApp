package com.example.currencyconversionapp.presentation.feature.comparison

import app.cash.turbine.test
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import com.example.currencyconversionapp.presentation.feature.conversion.CurrencyCode
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
class ComparisonViewModelTest {
    private lateinit var mockRepository: CurrencyRepository
    private lateinit var viewModel: ComparisonViewModel
    private lateinit var testDispatcher: TestDispatchers

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setUp() {
        testDispatcher = TestDispatchers()
        mockRepository = mockk(relaxed = true)
        viewModel = ComparisonViewModel(mockRepository, testDispatcher)
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
    fun `compareCurrency() when unsuccessful call, then should return error`() =
        runTest {
            // Given
            val error = "error"
            coEvery { mockRepository.compareCurrency(any(), any(), any()) } throws Exception(error)
            // When
            viewModel.compareCurrency("USD", "USD,GBP", 1.0)

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(true, awaitItem().isError)
            }
        }

    @Test
    fun `compareCurrency() when server error, then should return error state`() =
        runTest {
            // Given
            val error = "server error"
            coEvery { mockRepository.compareCurrency(any(), any(), any()) } throws Exception(error)
            // When
            viewModel.compareCurrency("USD", "USD,GBP", 1.0)

            delay(10L)

            // Then
            viewModel.state.test {
                assertEquals(true, awaitItem().isError)
            }
        }

    @Test
    fun `onBaseCurrencyChanged() should update baseCurrency in state`() {
        // When
        viewModel.onBaseCurrencyChanged("USD")

        // Then
        val newState = viewModel.state.value
        assertEquals(CurrencyCode.USD, newState.baseCurrency)
    }

    @Test
    fun `onTargetOneCurrencyChanged() should update targetOneCurrency in state`() {
        // When
        viewModel.onTargetOneCurrencyChanged("GBP")

        // Then
        val newState = viewModel.state.value
        assertEquals(CurrencyCode.GBP, newState.targetOneCurrency)
    }

    @Test
    fun `onTargetTwoCurrencyChanged() should update targetTwoCurrency in state`() {
        // When
        viewModel.onTargetTwoCurrencyChanged("EUR")

        // Then
        val newState = viewModel.state.value
        assertEquals(CurrencyCode.EUR, newState.targetTwoCurrency)
    }

    @Test
    fun `onAmountChanged() with valid amount should update amount in state`() {
        // When
        viewModel.onAmountChanged("10.0")

        // Then
        val newState = viewModel.state.value
        assertEquals(10.0, newState.amount, 0.0)
        assertFalse(newState.isAmountError)
    }

    @Test
    fun `onAmountChanged() with invalid amount should set isAmountError to true`() {
        // When
        viewModel.onAmountChanged("-5.0")

        // Then
        val newState = viewModel.state.value
        assertTrue(newState.isAmountError)
    }


}