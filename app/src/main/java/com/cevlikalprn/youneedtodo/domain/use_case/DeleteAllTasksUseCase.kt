package com.cevlikalprn.youneedtodo.domain.use_case

import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteAllTasksUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {

    suspend operator fun invoke() {
        toDoRepository.deleteAllTasks()
    }
}