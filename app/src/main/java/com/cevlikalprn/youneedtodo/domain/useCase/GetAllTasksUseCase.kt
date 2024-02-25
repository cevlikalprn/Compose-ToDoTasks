package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskListMapper: TaskListMapper
) {

    operator fun invoke(priority: Priority): Flow<List<ToDoTask>> {
        val tasks = when (priority) {
            Priority.LOW -> {
                toDoRepository.getSortedByLowPriority()
            }

            Priority.HIGH -> {
                toDoRepository.getSortedByHighPriority()
            }

            else -> {
                toDoRepository.getAllTasks()
            }
        }

        return tasks.map { toDoTaskEntityList ->
            taskListMapper(toDoTaskEntityList.orEmpty())
        }
    }
}
