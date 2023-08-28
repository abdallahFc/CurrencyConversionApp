package com.example.currencyconversionapp.presentation.feature.favourites


import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.components.AddToFavourites
import com.example.currencyconversionapp.presentation.components.currenciesList
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme
import kotlinx.coroutines.launch

@Composable
fun FavouritesScreen(favViewModel: FavouritesViewModel = hiltViewModel()) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    /*val addedList = mutableListOf<String>()*/
    /*val deletedList = mutableListOf<String>()*/

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
                AddToFavourites(
                    currencyName = currency.name,
                    flag = currency.flag,
                    code = currency.code,
                ) {
                    if (!it) {
                        Log.d("currency", "${currency.id}")
                        scope.launch {
                            /*deletedList.add(currency.name)*/
                            favViewModel.deleteCurrency(currency.code)
                        }
                        Toast.makeText(
                            context,
                            "${currency.name} Deleted from Favourites!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (it) {
                        scope.launch {
                            /*addedList.add(currency.name)*/
                            favViewModel.insertCurrency(currency)
                        }
                        Toast.makeText(
                            context,
                            "${currency.name} Added to Favourites!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFav() {
    CurrencyConversionAppTheme {
        FavouritesScreen()
    }

}