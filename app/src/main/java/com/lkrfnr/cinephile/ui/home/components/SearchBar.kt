package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.ui.theme.alternativeSearchBarColor
import com.lkrfnr.cinephile.ui.theme.searchTextColor

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(top = 8.dp),
        contentAlignment = Alignment.Center
    ) {

        val inputValue = remember { mutableStateOf(TextFieldValue()) }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.search_bar_rounded_corner)))
                .background(color = alternativeSearchBarColor)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                "search icon", Modifier.size(24.dp, 24.dp)
            )
            TextField(
                value = inputValue.value,
                onValueChange = { inputValue.value = it },
                label = {
                    Text(
                        text = "Search",
                        color = searchTextColor
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = searchTextColor,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Image(
                painter = painterResource(id = R.drawable.recorder),
                "mic icon",
                modifier = Modifier.size(24.dp, 24.dp)
            )

        }
    }
}