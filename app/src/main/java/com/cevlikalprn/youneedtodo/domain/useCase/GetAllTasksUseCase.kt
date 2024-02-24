package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskListMapper: TaskListMapper
) {

    suspend operator fun invoke(priority: Priority): List<ToDoTask> {
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
        return taskListMapper(tasks.orEmpty())
    }
}
