package com.cevlikalprn.youneedtodo.presentation.screen.task

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask

data class TaskUiState(
    val toDoTask: ToDoTask?,
    val errorMessage: String?
) {

    companion object {
        val Default = TaskUiState(
            toDoTask = ToDoTask.NewToDoTask,
            errorMessage = null
        )
    }
}
