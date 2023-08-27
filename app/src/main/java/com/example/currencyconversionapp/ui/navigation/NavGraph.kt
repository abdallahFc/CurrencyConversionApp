package com.example.currencyconversionapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.currencyconversionapp.ui.feature.favourites.favouritesRoute
import com.example.currencyconversionapp.ui.feature.home.homeRoute
import com.example.currencyconversionapp.ui.navigation.LocalNavigationProvider
import com.example.currencyconversionapp.ui.navigation.Screen

@Composable
fun MainNavGraph() {
    val navController = LocalNavigationProvider.current
    NavHost(navController = navController, startDestination = Screen.Home.route,
        ) {
        homeRoute()
        favouritesRoute()
    }
}