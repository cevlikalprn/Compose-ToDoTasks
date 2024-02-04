package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
import com.cevlikalprn.youneedtodo.common.extension.longToastMessage

@Composable
fun TaskScreen(
    viewModel: TaskViewModel = hiltViewModel(),
    taskId: Int,
    navigateToListScreen: NavigateToListScreen
) {
    val context = LocalContext.current
    LaunchedEffect(
        key1 = true,
        block = {
            viewModel.getSelectedTask(taskId)
        }
    )
    val uiState by viewModel.selectedTask.collectAsState()
    Scaffold(
        topBar = {
            TaskScreenTopBar(
                uiState = uiState,
                navigateToListScreen = {
                    if (!viewModel.isReadyForAction(it)) {
                        context.longToastMessage(
                            context.getString(R.string.fields_empty)
                        )
                    } else {
                        navigateToListScreen(it)
                    }
                }
            )
        },
        content = { paddingValues ->
            TaskScreenContent(
                paddingValues = paddingValues,
                toDoTask = uiState.toDoTask,
                onTitleChange = {
                    viewModel.updateTaskTitle(it)
                },
                onPrioritySelected = {
                    viewModel.updateTaskPriority(it)
                },
                onDescriptionChange = {
                    viewModel.updateTaskDescription(it)
                }
            )
        }
    )
}