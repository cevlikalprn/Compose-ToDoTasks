package com.cevlikalprn.youneedtodo.presentation.list

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask

data class ListUiState(
    var success: Boolean = false,
    var toDoTasks: List<ToDoTask> = emptyList()
)
