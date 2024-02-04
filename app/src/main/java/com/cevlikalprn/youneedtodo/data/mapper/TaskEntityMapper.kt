package com.cevlikalprn.youneedtodo.data.mapper

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
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