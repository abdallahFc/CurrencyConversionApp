package com.example.currencyconversionapp.presentation.feature.home

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.mutableStateOf
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import com.example.currencyconversionapp.ConCurrencyApp
import com.example.currencyconversionapp.data.repo.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CurrencyRepository,
) : ViewModel() {

    init {
        when (repository.isDark())
        {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        ConCurrencyApp.appContext.findActivity()?.runOnUiThread {
            AppCompatDelegate.getDefaultNightMode()
        }
    }

    private val language = mutableStateOf("en")

    private val isDark = mutableStateOf(repository.isDark())

    fun isDarkMode(): Boolean {
        return isDark.value
    }

    fun isDark(): Boolean {
        repository.isDark()
        return repository.isDark()
    }


    fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }

    fun onLanguageChange() {
        when (LocaleListCompat.forLanguageTags(language.value)) {
            LocaleListCompat.forLanguageTags("en") -> {
                AppCompatDelegate.setApplicationLocales(
                    LocaleListCompat.forLanguageTags(
                        "ar"
                    )
                )
                language.value = "ar"
            }

            LocaleListCompat.forLanguageTags("ar") -> {
                AppCompatDelegate.setApplicationLocales(
                    LocaleListCompat.forLanguageTags(
                        "en"
                    )
                )
                language.value = "en"
            }
        }
        ConCurrencyApp.appContext.findActivity()?.runOnUiThread {
            AppCompatDelegate.getApplicationLocales()
        }
    }

    fun onModeChange() {
        when (isDark())
        {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                isDark.value = false
                repository.setDarkMode(false)
            }
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                isDark.value = true
                repository.setDarkMode(true)
            }
        }
        ConCurrencyApp.appContext.findActivity()?.runOnUiThread {
            AppCompatDelegate.getDefaultNightMode()
        }
        /*
        when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_NO -> {

            }

            AppCompatDelegate.MODE_NIGHT_YES -> {

            }

            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY -> {
                if (isDark()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    isDark.value = false
                    repository.setDarkMode(false)
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    isDark.value = true
                    repository.setDarkMode(true)
                }
            }

            AppCompatDelegate.MODE_NIGHT_AUTO_TIME -> {
                if (isDark()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    isDark.value = false
                    repository.setDarkMode(false)
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    isDark.value = true
                    repository.setDarkMode(true)
                }
            }

            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> {
                if (isDark()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    isDark.value = false
                    repository.setDarkMode(false)
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    isDark.value = true
                    repository.setDarkMode(true)
                }
            }

            AppCompatDelegate.MODE_NIGHT_UNSPECIFIED -> {
                if (isDark()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    isDark.value = false
                    repository.setDarkMode(false)
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    isDark.value = true
                    repository.setDarkMode(true)
                }
            }*/
        }
}