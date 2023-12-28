package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.ToolbarSearchOnClick
import com.cevlikalprn.youneedtodo.common.ToolbarSortOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.itemView.ToolbarSearchAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.itemView.ToolbarSortAction

@Composable
fun AppDefaultToolbar(
    title: String,
    titleColor: Color = MaterialTheme.colors.appTopBarContentColor,
    backgroundColor: Color = MaterialTheme.colors.appTopBarBackgroundColor,
    onSearchClick: ToolbarSearchOnClick,
    onSortOnClick: ToolbarSortOnClick
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
        },
        backgroundColor = backgroundColor
    )
}

@Composable
@Preview
fun AppDefaultToolbarPreview() {
    AppDefaultToolbar(
        title = "Toolbar Title",
        onSearchClick = {
            // no-op
        },
        onSortOnClick = {
            // no-op
        }
    )
}
