package com.cevlikalprn.youneedtodo.domain.mapper

import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import javax.inject.Inject

class TaskMapper @Inject constructor() {

    operator fun invoke(taskEntity: ToDoTaskEntity): ToDoTask {
        return ToDoTask(
            id = taskEntity.id,
            title = taskEntity.title,
            description = taskEntity.description,
            priority = taskEntity.priority
        )
    }
}