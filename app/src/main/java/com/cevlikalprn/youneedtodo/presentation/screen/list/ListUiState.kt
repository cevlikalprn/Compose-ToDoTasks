package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask

data class ListUiState(
    var success: Boolean,
    var toDoTasks: List<ToDoTask>
) {

    companion object {
        val Default = ListUiState(
            success = false,
            toDoTasks = emptyList()
        )
    }
}
