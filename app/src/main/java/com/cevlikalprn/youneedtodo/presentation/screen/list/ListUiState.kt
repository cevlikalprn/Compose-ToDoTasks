package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask

data class ListUiState(
    val errorMessage: String?,
    val areTasksFetched: Boolean,
    val toDoTasks: List<ToDoTask>?
) {

    companion object {
        val Default = ListUiState(
            areTasksFetched = false,
            toDoTasks = emptyList(),
            errorMessage = null
        )
    }
}
