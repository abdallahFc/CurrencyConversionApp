package com.example.currencyconversionapp.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.currencyconversionapp.data.source.local.CurrencyDao
import com.example.currencyconversionapp.data.source.local.CurrencyDatabase
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class DataBaseTest {
    private lateinit var db: CurrencyDatabase
    private lateinit var currencyDao: CurrencyDao

    @Before
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), CurrencyDatabase::class.java
        ).allowMainThreadQueries().build()
        currencyDao = db.currencyDao
    }

    @Test
    fun insertAndRetrieveCurrency() = runBlocking {
        // Given
        val currency = CurrencyEntity(
            1,
            "USD",
            "https://www.countryflags.io/us/flat/64.png",
            "United States Dollar"
        )

        // When
        currencyDao.insertCurrency(currency)
        val retrievedCurrency = currencyDao.getCurrencyByCode(currency.code)

        // Then
        assertEquals(currency.code, retrievedCurrency?.code)
        assertEquals(currency.flag, retrievedCurrency?.flag)
        assertEquals(currency.name, retrievedCurrency?.name)
    }

    @Test
    fun deleteCurrency() = runBlocking {
        // Given
        val currency = CurrencyEntity(
            1,
            "USD",
            "https://www.countryflags.io/us/flat/64.png",
            "United States Dollar"
        )
        currencyDao.insertCurrency(currency)

        // When
        currencyDao.deleteCurrency(currency.code)
        val retrievedCurrency = currencyDao.getCurrencyByCode(currency.code)

        // Then
        assertNull(retrievedCurrency)
    }

    @Test
    fun getAllCurrencies() = runBlocking {
        // Given
        val currency1 = CurrencyEntity(
            1,
            "USD",
            "https://www.countryflags.io/us/flat/64.png",
            "United States Dollar"
        )
        val currency2 =
            CurrencyEntity(2, "EUR", "https://www.countryflags.io/eu/flat/64.png", "Euro")
        currencyDao.insertCurrency(currency1)
        currencyDao.insertCurrency(currency2)

        // When
        val currencies = currencyDao.getCurrencies()

        // Then
        assertEquals(2, currencies.size)
        assertEquals(currency1, currencies[0])
        assertEquals(currency2, currencies[1])
    }

    @Test
    fun updateExistingCurrency() = runBlocking {
        // Given
        val initialCurrency = CurrencyEntity(
            1,
            "USD",
            "https://www.countryflags.io/us/flat/64.png",
            "United States Dollar"
        )
        currencyDao.insertCurrency(initialCurrency)

        val updatedCurrency =
            CurrencyEntity(2, "USD", "https://www.countryflags.io/us/flat/64.png", "US Dollar")

        // When
        currencyDao.insertCurrency(updatedCurrency)
        val retrievedCurrency = currencyDao.getCurrencyByCode(updatedCurrency.code)

        // Then
        assertEquals(updatedCurrency.name, retrievedCurrency?.name)
    }

    @Test
    fun updateNonExistingCurrency() = runBlocking {
        // Given
        val updatedCurrency =
            CurrencyEntity(2, "USD", "https://www.countryflags.io/us/flat/64.png", "US Dollar")

        // When
        currencyDao.insertCurrency(updatedCurrency)
        val retrievedCurrency = currencyDao.getCurrencyByCode(updatedCurrency.code)

        // Then
        assertEquals(updatedCurrency.name, retrievedCurrency?.name)
    }

    @Test
    fun insertMultipleCurrencies() = runBlocking {
        // Given
        val currency1 = CurrencyEntity(
            1,
            "USD",
            "https://www.countryflags.io/us/flat/64.png",
            "United States Dollar"
        )
        val currency2 =
            CurrencyEntity(2, "EUR", "https://www.countryflags.io/eu/flat/64.png", "Euro")
        val currency3 =
            CurrencyEntity(3, "GBP", "https://www.countryflags.io/gb/flat/64.png", "British Pound")
        val currency4 =
            CurrencyEntity(4, "INR", "https://www.countryflags.io/in/flat/64.png", "Indian Rupee")
        val currency5 = CurrencyEntity(
            5,
            "AUD",
            "https://www.countryflags.io/au/flat/64.png",
            "Australian Dollar"
        )

        // When
        currencyDao.insertCurrency(currency1)
        currencyDao.insertCurrency(currency2)
        currencyDao.insertCurrency(currency3)
        currencyDao.insertCurrency(currency4)
        currencyDao.insertCurrency(currency5)
        val currencies = currencyDao.getCurrencies()
        // Then
        assertEquals(5, currencies.size)
        assertEquals(currency1, currencies[0])
        assertEquals(currency2, currencies[1])
        assertEquals(currency3, currencies[2])
        assertEquals(currency4, currencies[3])
        assertEquals(currency5, currencies[4])
    }

    @Test
    fun getCurrencyByCode_existingCurrency() = runBlocking {
        // Given
        val currency = CurrencyEntity(1,"USD", "https://www.countryflags.io/us/flat/64.png", "United States Dollar")
        currencyDao.insertCurrency(currency)

        // When
        val retrievedCurrency = currencyDao.getCurrencyByCode(currency.code)

        // Then
        assertNotNull(retrievedCurrency)
        assertEquals(currency, retrievedCurrency)
    }

    @Test
    fun getCurrencyByCode_nonExistingCurrency() = runBlocking {
        // When
        val retrievedCurrency = currencyDao.getCurrencyByCode("EUR")

        // Then
        assertNull(retrievedCurrency)
    }

    @Test
    fun deleteCurrency_existingCurrency() = runBlocking {
        // Given
        val currency = CurrencyEntity(1,"USD", "https://www.countryflags.io/us/flat/64.png", "United States Dollar")
        currencyDao.insertCurrency(currency)

        // When
        currencyDao.deleteCurrency(currency.code)
        val retrievedCurrency = currencyDao.getCurrencyByCode(currency.code)

        // Then
        assertNull(retrievedCurrency)
    }

}
