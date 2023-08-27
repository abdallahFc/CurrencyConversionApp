package com.example.currencyconversionapp.presentation.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.currencyconversionapp.presentation.navigation.Screen

private val ROUTE= Screen.Home.route

fun NavGraphBuilder.homeRoute() {
    composable(ROUTE) { HomeScreen() }
}