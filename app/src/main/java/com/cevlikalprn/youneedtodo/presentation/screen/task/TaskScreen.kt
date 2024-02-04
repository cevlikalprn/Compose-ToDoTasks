package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
import com.cevlikalprn.youneedtodo.domain.model.Priority

@Composable
fun TaskScreen(
    viewModel: TaskViewModel = hiltViewModel(),
    taskId: Int,
    navigateToListScreen: NavigateToListScreen
) {
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
                navigateToListScreen = navigateToListScreen
            )
        },
        content = { paddingValues ->
            TaskScreenContent(
                paddingValues = paddingValues,
                title = "",
                description = "",
                priority = Priority.LOW,
                onTitleChange = {},
                onPrioritySelected = {},
                onDescriptionChange = {}
            )
        }
    )
}