package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    operator fun invoke(taskId: Int): Flow<ToDoTask> {
        return toDoRepository.getSelectedTask(taskId)
    }
}