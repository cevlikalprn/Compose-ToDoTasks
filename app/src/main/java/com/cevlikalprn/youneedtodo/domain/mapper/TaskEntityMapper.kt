package com.cevlikalprn.youneedtodo.domain.mapper

import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import javax.inject.Inject

class TaskEntityMapper @Inject constructor() {

    operator fun invoke(toDoTask: ToDoTask): ToDoTaskEntity {
        return ToDoTaskEntity(
            title = toDoTask.title,
            description = toDoTask.description,
            priority = toDoTask.priority
        )
    }
}