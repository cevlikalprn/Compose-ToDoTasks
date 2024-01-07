package com.cevlikalprn.youneedtodo.presentation.screen.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.model.SearchAppBarState
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppDefaultTopBar
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppSearchTopBar
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarDeleteAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarSearchAction
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem.TopBarSortAction

@Composable
fun ListScreenTopBar(
    viewModel: ListViewModel
) {
    val searchAppBarState by viewModel.searchAppBarState

    when (searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultTopBar(viewModel)
        }

        else -> {
            SearchTopBar(viewModel)
        }
    }
}

@Composable
private fun DefaultTopBar(viewModel: ListViewModel) {
    AppDefaultTopBar(
        title = stringResource(R.string.list_screen_title),
        actions = {
            TopBarSearchAction(
                onSearchClick = {
                    viewModel.updateSearchAppBarState(
                        SearchAppBarState.OPENED
                    )
                }
            )
            TopBarSortAction(onSortClick = {})
            TopBarDeleteAction(onDeleteClick = {})
        }
    )
}

@Composable
private fun SearchTopBar(viewModel: ListViewModel) {
    val searchTextState by viewModel.searchTextState

    AppSearchTopBar(
        searchText = searchTextState,
        onTextChange = { searchedText ->
            viewModel.updateSearchTextState(searchedText)
        },
        onSearchClick = {},
        onCloseClick = {
            viewModel.updateSearchAppBarState(
                SearchAppBarState.CLOSED
            )
            viewModel.updateSearchTextState(EMPTY_STRING)
        }
    )
}