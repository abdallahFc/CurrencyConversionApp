package com.example.currencyconversionapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val DarkColorScheme = darkColorScheme(
    primary = ButtonColor,
    secondary = FieldShadowColor,
    tertiary = CurrencyNameColor,
    background = BackgroundDark,
    surface = CardBackgroundDark,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = TextColorDark,
    onSurface = TextColorDark,
)

// LightColorScheme
val LightColorScheme = lightColorScheme(
    primary = ButtonColor,
    secondary = FieldShadowColor,
    tertiary = CurrencyNameColor,
    background = White,
    surface = CardColor,
    onPrimary = Black,
    onSecondary = Black,
    onTertiary = Black,
    onBackground = DarkGrey,
    onSurface = DarkGrey,
)

@Composable
fun CurrencyConversionAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    useDarkIcons: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val systemUiController = rememberSystemUiController()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
            isNavigationBarContrastEnforced = false
        )

        onDispose {}
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}