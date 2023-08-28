package com.example.currencyconversionapp.presentation.feature.conversion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.components.CurrencyItem
import com.example.currencyconversionapp.presentation.components.currenciesList
import com.example.currencyconversionapp.presentation.feature.favourites.FavouritesScreen
import com.example.currencyconversionapp.presentation.feature.favourites.navigateToFavouritesScreen
import com.example.currencyconversionapp.presentation.navigation.LocalNavigationProvider
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme

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
fun ConverterScreen() {
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
        ModalBottomSheet(
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface,
            onDismissRequest = { isSheetOpened = false }
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                FavouritesScreen()
                Spacer(modifier = Modifier.weight(1f))
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
                        colorFilter = ColorFilter.tint(color=MaterialTheme.colorScheme.onPrimary)
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
        items(currenciesList.size) {
            CurrencyItem(
                currencyName = currenciesList[it].name,
                flag = currenciesList[it].flag,
                rate = "1.32"
            )
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
