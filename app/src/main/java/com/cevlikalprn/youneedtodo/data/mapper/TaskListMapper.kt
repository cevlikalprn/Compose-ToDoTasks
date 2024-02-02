package com.cevlikalprn.youneedtodo.data.mapper

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import javax.inject.Inject

class TaskListMapper @Inject constructor() {

    operator fun invoke(toDoTaskList: List<ToDoTaskEntity>): List<ToDoTask> {
        return toDoTaskList.map { entity ->
            ToDoTask(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                priority = entity.priority
            )
        }
    }
}