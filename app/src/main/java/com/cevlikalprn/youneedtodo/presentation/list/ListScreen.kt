package com.cevlikalprn.youneedtodo.presentation.list

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreenAction
import com.cevlikalprn.youneedtodo.presentation.uipack.AppFloatingActionButton

@Composable
fun ListScreen(
    navigateToTaskScreenAction: NavigateToTaskScreenAction
) {
    Scaffold(
        floatingActionButton = {
            AppFloatingActionButton(
                iconImageVector = Icons.Filled.Add,
                onClick = {
                    navigateToTaskScreenAction(ADD_TASK_ID)
                }
            )
        },
        content = { paddingValues ->
            paddingValues
        }
    )
}

