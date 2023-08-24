package com.example.currencyconversionapp.ui.feature.favourites


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.composables.AddToFavourites
import com.example.currencyconversionapp.ui.composables.currenciesList
import com.example.currencyconversionapp.ui.theme.White

@Composable
fun FavouritesScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()/*width(365.dp)*/
                .background(color = White)
                /*.height(50.dp)*/
                .padding(top = 45.dp, end = 35.dp, bottom = 40.dp)
        ) {

            IconButton(
                onClick = { },
                modifier = Modifier
                    .padding(0.63649.dp)
                    .width(20.36777.dp)
                    .height(20.36777.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "close favourites page"
                )
            }

        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(335.dp)
                .height(551.dp)
                .padding(/*start = 20.dp, end = 20.dp, top = 40.dp, bottom = 150.dp*/)
        ) {

            Text(
                text = "My  Favorites",
                style = TextStyle(
                    fontSize = 17.34.sp,
                    lineHeight = 23.12.sp,
                    /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
                    fontWeight = FontWeight(500),
                    color = Color(0xFF121212),
                ),
                modifier = Modifier.padding(start = 10.dp, top = 29.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp, bottom = 29.dp)
            )
            {
                /*item {

                }*/
                items(currenciesList) {
                    AddToFavourites(currencyTitle = it.currencyName, flag = it.currencyFlag)
                    Divider(
                        modifier = Modifier
                            .width(315.dp)
                            .height(0.9633.dp)
                            .background(color = Color(0xFFB9C1D9))
                    )
                }
            }
        }
    }
}