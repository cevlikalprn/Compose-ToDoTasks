package com.cevlikalprn.youneedtodo.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SearchAppBarState
import com.cevlikalprn.youneedtodo.presentation.ToDoViewModel
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppDefaultTopBar
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppSearchTopBar

@Composable
fun ListScreenTopBar(
    viewModel: ToDoViewModel
) {
    val searchAppBarState by viewModel.searchAppBarState
    val searchTextState by viewModel.searchTextState

    when (searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            AppDefaultTopBar(
                title = stringResource(R.string.task_screen_name),
                onSearchClick = {
                    viewModel.updateSearchAppBarState(
                        SearchAppBarState.OPENED
                    )
                },
                onSortOnClick = {},
                onDeleteOnClick = {}
            )
        }

        else -> {
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
    }
}