package com.bintangpoetra.mangakyu.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.bintangpoetra.mangakyu.R
import com.bintangpoetra.mangakyu.ui.theme.Grey100

@Composable
fun SearchBar(
    query: String,
    placeholder: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    onEraseQuery: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = Grey100,
        shape = RoundedCornerShape(5.dp),
        elevation = 0.dp,
        modifier = modifier
    ) {

        val screenWidth = LocalConfiguration.current.screenWidthDp

        var text by remember { mutableStateOf(placeholder) }

        Text(
            text = if (query.isEmpty()) text else "",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { text = "" }
                .padding(
                    start = 60.dp,
                    end = 10.dp,
                    top = 11.dp,
                )
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp)
            )

            BasicTextField(
                value = query,
                singleLine = true,
                maxLines = 1,
                textStyle = TextStyle(
                    color = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    imeAction = ImeAction.Search
                ),

                keyboardActions = KeyboardActions(
                    onSearch = {
                        onExecuteSearch()
                    }
                ),

                onValueChange = {
                    onQueryChanged(it)
                    text = ""
                },

                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 11.dp, bottom = 5.dp)
                    .width((screenWidth - 150).dp)
                    .height(30.dp)
            )

            if (query != "") {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cancel),
                    contentDescription = null,
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onEraseQuery()
                        }
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

        }
    }
}