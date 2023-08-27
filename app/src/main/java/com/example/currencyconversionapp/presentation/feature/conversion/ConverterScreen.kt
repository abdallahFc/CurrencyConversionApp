package com.example.currencyconversionapp.presentation.feature.conversion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    text = "live exchange rates",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                val navController = LocalNavigationProvider.current
                OutlinedButton(
                    onClick = {
                              navController.navigateToFavouritesScreen()
                    },
                    modifier = Modifier
                        .height(35.dp)
                ) {
                    Image(
                        modifier=Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "Add Icon"
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
        items(currenciesList.size) {
            CurrencyItem(
                currencyTitle = currenciesList[it].currencyName,
                flag = currenciesList[it].currencyFlag,
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
