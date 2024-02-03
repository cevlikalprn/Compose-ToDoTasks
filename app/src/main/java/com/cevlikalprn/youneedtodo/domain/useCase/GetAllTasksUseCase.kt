package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.AppResult
import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskListMapper: TaskListMapper
) {

    suspend operator fun invoke(): AppResult<List<ToDoTask>> {
        return when (val tasks = toDoRepository.getAllTasks()) {
            is AppResult.Success -> {
                AppResult.Success(taskListMapper(tasks.data ?: emptyList()))
            }

            is AppResult.Error -> {
                tasks
            }
        }
    }
}
