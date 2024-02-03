package com.cevlikalprn.youneedtodo.data.mapper

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
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