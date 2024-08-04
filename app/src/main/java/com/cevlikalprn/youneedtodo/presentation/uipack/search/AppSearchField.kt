package com.cevlikalprn.youneedtodo.presentation.uipack.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.presentation.util.SearchOnCloseClick
import com.cevlikalprn.youneedtodo.presentation.util.SearchOnSearchClick
import com.cevlikalprn.youneedtodo.presentation.util.SearchOnTextChange
import com.cevlikalprn.youneedtodo.presentation.util.SimpleOnClick

@Composable
fun AppSearchField(
    modifier: Modifier = Modifier,
    searchText: String = EMPTY_STRING,
    placeHolderText: String = stringResource(R.string.search_label),
    placeHolderTextColor: Color = Color.White,
    textStyle: TextStyle = TextStyle(
        color = Color.White,
        fontSize = MaterialTheme.typography.subtitle1.fontSize
    ),
    searchIconTint: Color = Color.White,
    closeIconTint: Color = Color.White,
    cursorColor: Color = Color.White,
    onTextChange: SearchOnTextChange,
    onSearchClick: SearchOnSearchClick,
    onCloseClick: SearchOnCloseClick,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = onTextChange,
        placeholder = {
            PlaceHolderText(
                text = placeHolderText,
                color = placeHolderTextColor
            )
        },
        textStyle = textStyle,
        singleLine = true,
        leadingIcon = {
            SearchIcon(
                text = searchText,
                onSearchClick = onSearchClick,
                tint = searchIconTint
            )
        },
        trailingIcon = {
            CloseIcon(
                searchText = searchText,
                onTextChange = onTextChange,
                onCloseClick = onCloseClick,
                tint = closeIconTint
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchClick(searchText)
            }
        ),
        colors = searchFieldColors(cursorColor = cursorColor)
    )
}

@Composable
private fun PlaceHolderText(
    text: String,
    color: Color
) {
    Text(
        modifier = Modifier.alpha(ContentAlpha.medium),
        text = text,
        color = color
    )
}

@Composable
private fun SearchIcon(
    text: String,
    onSearchClick: SearchOnSearchClick,
    tint: Color
) {
    IconContent(
        modifier = Modifier.alpha(ContentAlpha.disabled),
        onClick = { onSearchClick(text) },
        imageVector = Icons.Filled.Search,
        iconTint = tint
    )
}

@Composable
private fun CloseIcon(
    searchText: String,
    onTextChange: SearchOnTextChange,
    onCloseClick: SearchOnCloseClick,
    tint: Color
) {
    IconContent(
        onClick = {
            if (searchText.isNotEmpty()) {
                onTextChange(EMPTY_STRING)
            } else {
                onCloseClick()
            }
        },
        imageVector = Icons.Filled.Close,
        iconTint = tint
    )
}

@Composable
private fun IconContent(
    modifier: Modifier = Modifier,
    onClick: SimpleOnClick,
    imageVector: ImageVector,
    iconTint: Color
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = EMPTY_STRING,
            tint = iconTint
        )
    }
}

@Composable
private fun searchFieldColors(
    cursorColor: Color
) = TextFieldDefaults.textFieldColors(
    cursorColor = cursorColor,
    focusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    backgroundColor = Color.Transparent
)

@Composable
@Preview
private fun AppSearchFieldPreview() {
    AppSearchField(
        onTextChange = {
            // do nothing
        },
        onSearchClick = {
            // do nothing
        },
        onCloseClick = {
            // do nothing
        }
    )
}