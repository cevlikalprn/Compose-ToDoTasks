package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.TopBarDeleteOnClick
import com.cevlikalprn.youneedtodo.common.TopBarSearchOnClick
import com.cevlikalprn.youneedtodo.common.TopBarSortOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarDeleteAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarSearchAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarSortAction

@Composable
fun AppDefaultTopBar(
    title: String,
    titleColor: Color = MaterialTheme.colors.appTopBarContentColor,
    backgroundColor: Color = MaterialTheme.colors.appTopBarBackgroundColor,
    onSearchClick: TopBarSearchOnClick,
    onSortOnClick: TopBarSortOnClick,
    onDeleteOnClick: TopBarDeleteOnClick
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = titleColor
            )
        },
        actions = {
            TopBarSearchAction(onSearchClick = onSearchClick)
            TopBarSortAction(onSortClick = onSortOnClick)
            TopBarDeleteAction(onDeleteClick = onDeleteOnClick)
        },
        backgroundColor = backgroundColor
    )
}

@Composable
@Preview
private fun AppDefaultTopBarPreview() {
    AppDefaultTopBar(
        title = "Top bar title",
        onSearchClick = {
            // no-op
        },
        onSortOnClick = {
            // no-op
        },
        onDeleteOnClick = {
            // no-op
        }
    )
}
