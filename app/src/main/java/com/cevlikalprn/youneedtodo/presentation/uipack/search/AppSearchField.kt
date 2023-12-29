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
import com.cevlikalprn.youneedtodo.common.SearchOnCloseClick
import com.cevlikalprn.youneedtodo.common.SearchOnSearchClick
import com.cevlikalprn.youneedtodo.common.SearchOnTextChange
import com.cevlikalprn.youneedtodo.common.SimpleOnClick

@Composable
fun AppSearchField(
    modifier: Modifier = Modifier,
    text: String = EMPTY_STRING,
    placeHolderText: String = stringResource(R.string.search_label),
    placeHolderTextColor: Color = Color.White,
    textStyle: TextStyle = TextStyle(
        color = Color.White,
        fontSize = MaterialTheme.typography.subtitle1.fontSize
    ),
    leadingIconTint: Color = Color.White,
    trailingIconTint: Color = Color.White,
    onTextChange: SearchOnTextChange,
    onSearchClick: SearchOnSearchClick,
    onCloseClick: SearchOnCloseClick,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onTextChange,
        placeholder = {
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = placeHolderText,
                color = placeHolderTextColor
            )
        },
        textStyle = textStyle,
        singleLine = true,
        leadingIcon = {
            IconContent(
                modifier = Modifier.alpha(ContentAlpha.disabled),
                onClick = { onSearchClick(text) },
                imageVector = Icons.Filled.Search,
                iconTint = leadingIconTint
            )
        },
        trailingIcon = {
            IconContent(
                modifier = Modifier.alpha(ContentAlpha.disabled),
                onClick = { onCloseClick() },
                imageVector = Icons.Filled.Close,
                iconTint = trailingIconTint
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchClick(text)
            }
        )
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
@Preview
private fun AppSearchFieldPreview() {
    AppSearchField(
        onTextChange = {
            // no-op
        },
        onSearchClick = {
            // no-op
        },
        onCloseClick = {
            // no-op
        }
    )
}