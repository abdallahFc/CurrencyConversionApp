package com.example.currencyconversionapp.ui.feature.favourites

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.currencyconversionapp.ui.navigation.Screen


private val ROUTE= Screen.Favorites.route

fun NavController.navigateToFavouritesScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.favouritesRoute() {
    composable(ROUTE) { FavouritesScreen() }
}