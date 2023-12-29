package com.cevlikalprn.youneedtodo.presentation.list

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.presentation.uipack.button.AppFloatingActionButton
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppDefaultTopBar

@Composable
fun ListScreen(
    navigateToTaskScreen: NavigateToTaskScreen
) {
    Scaffold(
        topBar = {
            AppDefaultTopBar(
                title = stringResource(R.string.task_screen_name),
                onSearchClick = {},
                onSortOnClick = {},
                onDeleteOnClick = {}
            )
        },
        floatingActionButton = {
            AppFloatingActionButton(
                iconImageVector = Icons.Filled.Add,
                onClick = {
                    navigateToTaskScreen(ADD_TASK_ID)
                }
            )
        },
        content = { paddingValues ->
            paddingValues
        }
    )
}

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(
        navigateToTaskScreen = {
            // do nothing
        }
    )
}
