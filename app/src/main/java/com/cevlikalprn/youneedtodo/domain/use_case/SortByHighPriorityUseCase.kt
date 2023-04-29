package com.cevlikalprn.youneedtodo.domain.use_case

import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class SortByHighPriorityUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
    ) {
}