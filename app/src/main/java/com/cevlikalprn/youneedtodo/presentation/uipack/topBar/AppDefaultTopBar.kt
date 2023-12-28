package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.ToolbarDeleteOnClick
import com.cevlikalprn.youneedtodo.common.ToolbarSearchOnClick
import com.cevlikalprn.youneedtodo.common.ToolbarSortOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.ToolbarDeleteAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.ToolbarSearchAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.ToolbarSortAction

@Composable
fun AppDefaultToolbar(
    title: String,
    titleColor: Color = MaterialTheme.colors.appTopBarContentColor,
    backgroundColor: Color = MaterialTheme.colors.appTopBarBackgroundColor,
    onSearchClick: ToolbarSearchOnClick,
    onSortOnClick: ToolbarSortOnClick,
    onDeleteOnClick: ToolbarDeleteOnClick
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = titleColor
            )
        },
        actions = {
            ToolbarSearchAction(onSearchClick = onSearchClick)
            ToolbarSortAction(onSortClick = onSortOnClick)
            ToolbarDeleteAction(onDeleteClick = onDeleteOnClick)
        },
        backgroundColor = backgroundColor
    )
}

@Composable
@Preview
private fun AppDefaultToolbarPreview() {
    AppDefaultToolbar(
        title = "Toolbar Title",
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
