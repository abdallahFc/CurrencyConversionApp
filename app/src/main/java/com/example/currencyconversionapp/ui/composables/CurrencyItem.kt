package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R

@Composable
fun CurrencyItem(currencyList: List<String>) {
    LazyColumn {
        itemsIndexed(currencyList) { index: Int, item: String ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
                Image(
                    modifier = Modifier
                        .size(width = 44.dp, height = 44.dp)
                        .weight(1F),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.weight(2F)
                ) {
                    Text(
                        text = item,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
                            fontWeight = FontWeight(400),
                            color = Color(0xFF121212),
                        )
                    )
                    Text(
                        text = "CURRENCY",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB8B8B8),
                        )
                    )
                }
                Text(
                    text = "1.3",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
                        fontWeight = FontWeight(500),
                        color = Color(0xFF121212),
                        textAlign = TextAlign.Right,
                    ),
                    modifier = Modifier
                        .weight(1F)
                        .padding(20.dp)
                )
            }
            Divider(modifier=Modifier.fillMaxWidth().padding(horizontal = 20.dp))
        }
    }
}