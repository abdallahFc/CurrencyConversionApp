package com.example.currencyconversionapp

import com.example.currencyconversionapp.presentation.feature.comparison.ComparisonViewModelTest
import com.example.currencyconversionapp.presentation.feature.conversion.ConverterViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ComparisonViewModelTest::class,
    ConverterViewModelTest::class,
)
class TestSuite