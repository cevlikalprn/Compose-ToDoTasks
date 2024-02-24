package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class SearchDatabaseUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskListMapper: TaskListMapper
) {

    suspend operator fun invoke(query: String): List<ToDoTask> {
        return taskListMapper(toDoRepository.searchDatabase(query))
    }
}