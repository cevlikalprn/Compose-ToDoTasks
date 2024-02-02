package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SortByHighPriorityUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    operator fun invoke(): Flow<List<ToDoTaskEntity>> {
        return toDoRepository.getSortedByHighPriority()
    }
}