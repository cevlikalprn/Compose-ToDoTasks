package com.cevlikalprn.youneedtodo.presentation.screen.list

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.presentation.uipack.button.AppFloatingActionButton

@Composable
fun ListScreen(
    viewModel: ListViewModel = hiltViewModel(),
    navigateToTaskScreen: NavigateToTaskScreen
) {
    LaunchedEffect(
        key1 = true,
        block = {
            viewModel.getAllTasks()
        }
    )
    val uiState by viewModel.allTasks.collectAsState()
    Scaffold(
        topBar = {
            ListScreenTopBar(
                viewModel = viewModel,
                isDeleteAllActionVisible = !uiState.toDoTasks.isNullOrEmpty()
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
            ListScreenContent(
                paddingValues = paddingValues,
                uiState = uiState,
                navigateToTaskScreen = navigateToTaskScreen
            )
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
