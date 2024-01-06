package com.cevlikalprn.youneedtodo.presentation.list.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.common.SimpleComposableContent
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.presentation.list.ListUiState
import com.cevlikalprn.youneedtodo.presentation.uipack.component.emptPage.AppEmptyPageContent

@Composable
fun ListScreenContent(
    paddingValues: PaddingValues,
    uiState: ListUiState,
    navigateToTaskScreen: NavigateToTaskScreen
) {
    if (uiState.success) {
        HandleScreenState(
            isDataReady = uiState.toDoTasks.isNotEmpty(),
            tasksContent = {
                DisplayTodoTasks(
                    paddingValues,
                    uiState.toDoTasks,
                    navigateToTaskScreen
                )
            },
            emptyContent = {
                AppEmptyPageContent()
            }
        )
    }
}

@Composable
private fun HandleScreenState(
    isDataReady: Boolean,
    tasksContent: SimpleComposableContent,
    emptyContent: SimpleComposableContent
) {
    if (isDataReady) {
        tasksContent()
    } else {
        emptyContent()
    }
}

@Composable
private fun DisplayTodoTasks(
    paddingValues: PaddingValues,
    tasks: List<ToDoTask>,
    navigateToTaskScreen: NavigateToTaskScreen
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        content = {
            items(
                items = tasks,
                key = { todoTask ->
                    todoTask.id
                },
                itemContent = { toDoTask ->
                    ListScreenContentItem(
                        toDoTask = toDoTask,
                        navigateToTaskScreen = navigateToTaskScreen
                    )
                }
            )
        }
    )
}