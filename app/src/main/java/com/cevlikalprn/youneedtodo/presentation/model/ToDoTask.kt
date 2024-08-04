package com.cevlikalprn.youneedtodo.presentation.model

import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.navigation.util.Constants.ADD_TASK_ID

data class ToDoTask(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority
) {

    companion object {
        val NewToDoTask = ToDoTask(
            id = ADD_TASK_ID,
            title = "",
            description = "",
            priority = Priority.LOW
        )
    }
}
