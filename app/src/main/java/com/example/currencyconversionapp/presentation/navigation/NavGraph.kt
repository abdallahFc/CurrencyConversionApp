package com.example.currencyconversionapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.currencyconversionapp.presentation.feature.favourites.favouritesRoute
import com.example.currencyconversionapp.presentation.feature.home.homeRoute

@Composable
fun MainNavGraph() {
    val navController = LocalNavigationProvider.current
    NavHost(navController = navController, startDestination = Screen.Home.route,
        ) {
        homeRoute()
        favouritesRoute()
    }
}