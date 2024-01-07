package com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.TopBarSearchOnClick
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppSearchIconButton

@Composable
fun TopBarSearchAction(
    onSearchClick: TopBarSearchOnClick
) {
    AppSearchIconButton(onSearchClick = onSearchClick)
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