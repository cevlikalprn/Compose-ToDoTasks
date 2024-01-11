package com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.TopBarSearchOnClick
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppTopBarIconButton

@Composable
fun TopBarSearchAction(
    onSearchClick: TopBarSearchOnClick
) {
    AppTopBarIconButton(
        onClick = onSearchClick,
        icon = Icons.Filled.Search
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