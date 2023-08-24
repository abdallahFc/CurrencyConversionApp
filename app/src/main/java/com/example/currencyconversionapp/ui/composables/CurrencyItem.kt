package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.theme.LineShadowColor
import com.example.currencyconversionapp.ui.theme.White

@Composable
fun CurrencyItem(
    currencyTitle: String,
    flag: Int,
    rate:String
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Image(
                    painter = painterResource(id = flag),
                    contentDescription = "flag Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    androidx.compose.material.Text(
                        modifier = Modifier.padding(bottom = 2.dp),
                        text = currencyTitle,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                    Text(
                        text = "CURRENCY",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB8B8B8),
                        )
                    )
                }

            }

            Text(
                text = rate,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )

        }
       Divider(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.secondary)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFava() {
    CurrencyItem(
        "EGP",
        R.drawable.egypt_flag,
        "1.32"
    )
}

//LazyColumn {
//    itemsIndexed(currencyList) { index: Int, item: String ->
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(10.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Image(
//                modifier = Modifier
//                    .size(width = 44.dp, height = 44.dp)
//                    .weight(1F),
//                painter = painterResource(id = R.drawable.img),
//                contentDescription = "image description",
//                contentScale = ContentScale.None
//            )
//            Column(
//                verticalArrangement = Arrangement.SpaceBetween,
//                horizontalAlignment = Alignment.Start,
//                modifier = Modifier.weight(2F)
//            ) {
//                Text(
//                    text = item,
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        lineHeight = 24.sp,
//                        /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
//                        fontWeight = FontWeight(400),
//                        color = Color(0xFF121212),
//                    )
//                )
//                Text(
//                    text = "CURRENCY",
//                    style = TextStyle(
//                        fontSize = 12.sp,
//                        lineHeight = 20.sp,
//                        /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
//                        fontWeight = FontWeight(400),
//                        color = Color(0xFFB8B8B8),
//                    )
//                )
//            }
//            Text(
//                text = "1.3",
//                style = TextStyle(
//                    fontSize = 18.sp,
//                    lineHeight = 24.sp,
//                    /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
//                    fontWeight = FontWeight(500),
//                    color = Color(0xFF121212),
//                    textAlign = TextAlign.Right,
//                ),
//                modifier = Modifier
//                    .weight(1F)
//                    .padding(20.dp)
//            )
//        }
//        Divider(modifier=Modifier.fillMaxWidth().padding(horizontal = 20.dp))
//    }
//}