package com.example.currencyconversionapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R

@Composable
fun ModesDropDown(
    onLanguageChange: () -> Unit,
    onModeChange: () -> Unit
    ) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = MaterialTheme.colors.background
            )
        }
        DropdownMenu(
            modifier = Modifier.background(color = androidx.compose.material3.MaterialTheme.colorScheme.surface),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                content = {
                    Text(
                        text = stringResource(R.string.change_language),
                        style = TextStyle(
                            fontSize = 16.sp,
                            /*fontFamily = FontFamily(Font(R.font.open sans)),*/
                            fontWeight = FontWeight(400),
                            color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
                        )
                    )
                },
                onClick = onLanguageChange
            )
            DropdownMenuItem(
                content = {
                    Text(
                        text = stringResource(R.string.change_mode),
                        style = TextStyle(
                            fontSize = 16.sp,
                            /*fontFamily = FontFamily(Font(R.font.open sans)),*/
                            fontWeight = FontWeight(400),
                            color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
                        )
                    )
                },
                onClick = onModeChange
            )
        }
    }
}
