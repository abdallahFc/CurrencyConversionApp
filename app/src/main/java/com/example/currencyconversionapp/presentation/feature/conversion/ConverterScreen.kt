package com.example.currencyconversionapp.presentation.feature.conversion

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.composables.CurrencyItem
import com.example.currencyconversionapp.ui.composables.currenciesList
import com.example.currencyconversionapp.ui.feature.favourites.FavouritesScreen
import com.example.currencyconversionapp.ui.navigation.LocalNavigationProvider
import com.example.currencyconversionapp.ui.theme.CurrencyConversionAppTheme
import com.example.currencyconversionapp.domain.model.Currency
import com.example.currencyconversionapp.presentation.components.ContentVisibility
import com.example.currencyconversionapp.presentation.components.CurrencyItem
import com.example.currencyconversionapp.presentation.feature.favourites.FavouritesScreen
import com.example.currencyconversionapp.presentation.navigation.LocalNavigationProvider
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//val currenciesList = listOf(
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag),
//    Currency("EGP", R.drawable.egypt_flag)
//)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen(viewModel: ConverterViewModel = hiltViewModel()) {
    val scope = rememberCoroutineScope()
    var list by remember { mutableStateOf(listOf<Currency>()) }
    LaunchedEffect(key1 = Unit) {
        Log.d("currencies", list.toString())
        scope.launch {
            viewModel.getCurrencies()
            viewModel.favCurrenciesList.collectLatest {
                it?.let {
                    list = it.toMutableList()
                }
            }
        }
    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//    ) {
//        Converting()
//        Divider(modifier = Modifier
//            .fillMaxWidth()
//            .padding(30.dp))
//        LiveExchange()
//    }
    var isSheetOpened by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    if (isSheetOpened) {
        LaunchedEffect(key1 = Unit) {
            viewModel.getCurrencies()
        }
        ModalBottomSheet(
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface,
            onDismissRequest = {
                scope.launch {
                    viewModel.getCurrencies()
                }
                isSheetOpened = false
            }
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Image(
                    modifier = Modifier
                        .size(55.dp)
                        .aspectRatio(1f)
                        .align(Alignment.End)
                        .padding(16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                scope.launch {
                                    viewModel.getCurrencies()
                                    isSheetOpened = false
                                }
                            }),
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                )
                FavouritesScreen()
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.3f)
                )
            }
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        item {
            Converting()
        }
        item {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.live_exchange_rates),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                val navController = LocalNavigationProvider.current

                OutlinedButton(
                    onClick = {
                        isSheetOpened = true
                    },
                    modifier = Modifier
                        .height(35.dp)
                ) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "Add Icon",
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = stringResource(R.string.add_to_favorites),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    )
                }
            }
        }
        item {
            Text(
                text = stringResource(id = R.string.my_portfolio),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            )
        }

        if (list.isEmpty()) {
            item {
                Text(text = "No Favourite Currencies")
            }
        } else {
            items(list) {
                var showEmpty by remember {
                    mutableStateOf(false)
                }
                if (list.isEmpty()) {
                    showEmpty = true
                }
                ContentVisibility(state = showEmpty) {
                    Text(text = "No Favourite Currencies yet!")
                }
                CurrencyItem(
                    currencyName = it.name,
                    flag = it.flag,
                    rate = "1.32"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFav() {
    CurrencyConversionAppTheme {
        ConverterScreen()
    }

}
