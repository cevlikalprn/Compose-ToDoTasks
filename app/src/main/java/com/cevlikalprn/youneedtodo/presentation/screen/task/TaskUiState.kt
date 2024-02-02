package com.cevlikalprn.youneedtodo.presentation.screen.task

import com.cevlikalprn.youneedtodo.domain.model.Priority

data class TaskUiState(
    val success: Boolean,
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority
) {

    companion object {
        val Default = TaskUiState(
            success = false,
            id = 0,
            title = "",
            description = "",
            priority = Priority.NONE
        )
    }
}
