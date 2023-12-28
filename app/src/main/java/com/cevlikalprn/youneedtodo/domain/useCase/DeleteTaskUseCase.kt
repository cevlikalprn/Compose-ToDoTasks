package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    suspend operator fun invoke(toDoTask: ToDoTask) {
        toDoRepository.deleteTask(toDoTask)
    }
}