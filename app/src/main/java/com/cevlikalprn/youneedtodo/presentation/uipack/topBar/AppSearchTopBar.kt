package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SearchOnCloseClick
import com.cevlikalprn.youneedtodo.common.SearchOnSearchClick
import com.cevlikalprn.youneedtodo.common.SearchOnTextChange
import com.cevlikalprn.youneedtodo.presentation.theme.SEARCH_TOP_BAR_HEIGHT
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor
import com.cevlikalprn.youneedtodo.presentation.uipack.search.AppSearchField

@Composable
fun AppSearchTopBar(
    modifier: Modifier = Modifier,
    searchText: String = EMPTY_STRING,
    topBarContentColor: Color = MaterialTheme.colors.appTopBarContentColor,
    onTextChange: SearchOnTextChange,
    onSearchClick: SearchOnSearchClick,
    onCloseClick: SearchOnCloseClick,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(SEARCH_TOP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.appTopBarBackgroundColor
    ) {
        AppSearchField(
            searchText = searchText,
            onTextChange = onTextChange,
            onSearchClick = onSearchClick,
            onCloseClick = onCloseClick,
            placeHolderTextColor = topBarContentColor,
            searchIconTint = topBarContentColor,
            closeIconTint = topBarContentColor,
            textStyle = TextStyle(
                color = topBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            cursorColor = topBarContentColor
        )
    }
}

@Composable
@Preview
private fun AppSearchAppTopBarPreview() {
    AppSearchTopBar(
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