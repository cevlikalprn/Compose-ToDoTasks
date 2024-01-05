package com.cevlikalprn.youneedtodo.presentation.list

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.presentation.ToDoViewModel
import com.cevlikalprn.youneedtodo.presentation.list.content.ListScreenContent
import com.cevlikalprn.youneedtodo.presentation.uipack.button.AppFloatingActionButton

@Composable
fun ListScreen(
    viewModel: ToDoViewModel = hiltViewModel(),
    navigateToTaskScreen: NavigateToTaskScreen
) {
    Scaffold(
        topBar = {
            ListScreenTopBar(
                viewModel = viewModel
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
            ListScreenContent(paddingValues)
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
