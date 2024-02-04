package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskEntityMapper: TaskEntityMapper
) {

    suspend operator fun invoke(toDoTask: ToDoTask?) {
        toDoTask?.let {
            val entity = taskEntityMapper(it).copy(id = toDoTask.id)
            toDoRepository.updateTask(entity)
        }
    }
}
