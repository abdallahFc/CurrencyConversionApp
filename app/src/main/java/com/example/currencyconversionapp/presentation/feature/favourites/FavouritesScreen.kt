package com.example.currencyconversionapp.presentation.feature.favourites


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.components.AddToFavourites
import com.example.currencyconversionapp.presentation.components.ContentVisibility
import com.example.currencyconversionapp.presentation.components.currenciesList
import com.example.currencyconversionapp.presentation.navigation.LocalNavigationProvider
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme
import com.example.currencyconversionapp.presentation.theme.White
import com.example.currencyconversionapp.ui.feature.favourites.FavouritesViewModel
import kotlinx.coroutines.launch

@Composable
fun FavouritesScreen(favViewModel: FavouritesViewModel = viewModel()) {

    var isChecked by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    /*Column(
        modifier = Modifier
            .padding(vertical = 32.dp, horizontal = 16.dp)
            *//*.background(color = White)*//*
            .fillMaxHeight(0.85f)
    ) {
    val navController = LocalNavigationProvider.current
    Image(
        modifier = Modifier
            .size(55.dp)
            .aspectRatio(1f)
            .align(Alignment.End)
            .padding(16.dp)
            .clickable {
                scope.launch {
                    sheetState.collapse()
                }
                navController.navigateUp()
            },
        painter = painterResource(id = R.drawable.close),
        contentDescription = null
    )*/
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(/*top = 26.dp, bottom = 80.dp*/)
    ) {
        Text(
            text = stringResource(id = R.string.my_favourites),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onPrimary,
            ),
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(8.dp)
        )
        {
            items(currenciesList) { currency ->
                LaunchedEffect(key1 = Unit) {
                    scope.launch {
                        isChecked = (favViewModel.getCurrencyByCode(currency.code) != null)
                    }
                }
                AddToFavourites(
                    currencyName = currency.name,
                    flag = currency.flag,
                    isChecked = isChecked
                ) {
                    if (it && !isChecked) {
                        scope.launch {
                           // favViewModel.insertCurrency(currency)
                        }
                    }
                    if (!it && isChecked) {
                        scope.launch {
                            //favViewModel.deleteCurrency(currency)
                        }
                    }
                    isChecked = it
                }
            }
        }
    }
    /*Spacer(modifier = Modifier.weight(1f))*/
}
//}


@Preview(showBackground = true)
@Composable
fun PreviewFav() {
    CurrencyConversionAppTheme {
        FavouritesScreen()
    }

}