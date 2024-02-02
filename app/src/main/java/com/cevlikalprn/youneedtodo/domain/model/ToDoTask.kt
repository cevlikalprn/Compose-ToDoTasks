package com.cevlikalprn.youneedtodo.domain.model

data class ToDoTask(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority
)
