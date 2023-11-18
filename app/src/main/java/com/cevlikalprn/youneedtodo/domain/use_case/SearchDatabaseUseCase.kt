package com.cevlikalprn.youneedtodo.domain.use_case

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchDatabaseUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    operator fun invoke(query: String): Flow<List<ToDoTask>> {
        return toDoRepository.searchDatabase(query)
    }
}