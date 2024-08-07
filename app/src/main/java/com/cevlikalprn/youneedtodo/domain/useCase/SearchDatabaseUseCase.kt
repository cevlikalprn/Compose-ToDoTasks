package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.domain.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import com.cevlikalprn.youneedtodo.data.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchDatabaseUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskListMapper: TaskListMapper
) {

    operator fun invoke(query: String): Flow<List<ToDoTask>> {
        return toDoRepository
            .searchDatabase(query)
            .map { toDoTaskEntityList ->
                taskListMapper(toDoTaskEntityList)
            }
    }
}