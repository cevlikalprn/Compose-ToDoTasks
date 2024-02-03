package com.cevlikalprn.youneedtodo.domain.model

import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID

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
            priority = Priority.NONE
        )
    }
}
