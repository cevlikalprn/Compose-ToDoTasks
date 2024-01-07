package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask

data class ListUiState(
    var success: Boolean = false,
    var toDoTasks: List<ToDoTask> = emptyList()
)
