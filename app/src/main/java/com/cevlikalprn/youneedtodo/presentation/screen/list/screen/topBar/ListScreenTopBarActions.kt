package com.cevlikalprn.youneedtodo.presentation.screen.list.screen.topBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.cevlikalprn.youneedtodo.common.TopBarDeleteOnClick
import com.cevlikalprn.youneedtodo.common.TopBarSearchOnClick
import com.cevlikalprn.youneedtodo.common.TopBarSortOnClick
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarDeleteAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarSearchAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarSortAction

@Composable
fun RowScope.ListScreenTopBarActions(
    onSearchClick: TopBarSearchOnClick,
    onSortOnClick: TopBarSortOnClick,
    onDeleteOnClick: TopBarDeleteOnClick
) {
    TopBarSearchAction(onSearchClick = onSearchClick)
    TopBarSortAction(onSortClick = onSortOnClick)
    TopBarDeleteAction(onDeleteClick = onDeleteOnClick)
}