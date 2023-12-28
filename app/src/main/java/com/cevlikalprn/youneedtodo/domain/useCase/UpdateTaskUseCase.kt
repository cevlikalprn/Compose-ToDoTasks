package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    suspend operator fun invoke(toDoTask: ToDoTask) {
        toDoRepository.updateTask(toDoTask)
    }
}
