package com.example.currencyconversionapp.presentation.feature.favourites


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.components.AddToFavourites
import com.example.currencyconversionapp.presentation.components.ContentVisibility
import com.example.currencyconversionapp.presentation.components.currenciesList
import com.example.currencyconversionapp.presentation.navigation.LocalNavigationProvider
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme
import com.example.currencyconversionapp.presentation.theme.White

@Composable
fun FavouritesScreen() {
    ContentVisibility(state = true) {
        Column(
            modifier = Modifier
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .background(color = White)
        ) {
            val navController = LocalNavigationProvider.current
            Image(
                modifier = Modifier
                    .size(55.dp)
                    .aspectRatio(1f)
                    .align(Alignment.End)
                    .padding(16.dp)
                    .clickable {
                        navController.navigateUp()
                    },
                painter = painterResource(id = R.drawable.close),
                contentDescription = null
            )


            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(top = 26.dp, bottom = 80.dp)
            ) {

                Text(
                    text = "My Favorites",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF121212),
                    ),
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(8.dp)
                )
                {
                    items(currenciesList) {
                        AddToFavourites(currencyName = it.currencyName, flag = it.currencyFlag, true) {}

                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
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