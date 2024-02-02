package com.cevlikalprn.youneedtodo.presentation.screen.task

import com.cevlikalprn.youneedtodo.domain.model.Priority

data class TaskUiState(
    val success: Boolean = false,
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val priority: Priority = Priority.NONE
)
