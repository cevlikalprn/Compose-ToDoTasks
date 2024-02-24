package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask

data class ListUiState(
    var areTasksFetched: Boolean,
    var toDoTasks: List<ToDoTask>?
) {

    companion object {
        val Default = ListUiState(
            areTasksFetched = false,
            toDoTasks = emptyList()
        )
    }
}
