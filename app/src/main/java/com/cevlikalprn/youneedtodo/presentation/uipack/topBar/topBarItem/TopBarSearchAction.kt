package com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.TopBarSearchOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun TopBarSearchAction(
    onSearchClick: TopBarSearchOnClick,
    icon: ImageVector = Icons.Filled.Search,
    iconTint: Color = MaterialTheme.colors.appTopBarContentColor
) {
    IconButton(onClick = onSearchClick) {
        SearchIcon(
            icon = icon,
            tint = iconTint
        )
    }
}

@Composable
private fun SearchIcon(icon: ImageVector, tint: Color) {
    Icon(
        imageVector = icon,
        contentDescription = EMPTY_STRING,
        tint = tint
    )
}

@Composable
@Preview
private fun TopBarSearchActionPreview() {
    TopBarSearchAction(
        onSearchClick = {
            // do nothing
        }
    )
}