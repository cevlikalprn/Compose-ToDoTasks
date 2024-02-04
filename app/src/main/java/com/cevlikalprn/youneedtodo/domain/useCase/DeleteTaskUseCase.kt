package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val toDoTaskEntityMapper: TaskEntityMapper
) {

    suspend operator fun invoke(toDoTask: ToDoTask?) {
        toDoTask?.let {
            val entity = toDoTaskEntityMapper(it).copy(id = toDoTask.id)
            toDoRepository.deleteTask(entity)
        }
    }
}