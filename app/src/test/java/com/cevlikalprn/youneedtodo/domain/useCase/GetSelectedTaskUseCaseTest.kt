package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.Constants
import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.domain.mapper.TaskMapper
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetSelectedTaskUseCaseTest {

    private lateinit var toDoRepository: FakeToDoRepository
    private lateinit var getSelectedTaskUseCase: GetSelectedTaskUseCase

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        getSelectedTaskUseCase = GetSelectedTaskUseCase(
            toDoRepository,
            TaskMapper()
        )
    }

    @Test
    fun getSelectedTask_selectedTaskIsListed_returnsTrue() = runBlocking {
        for (i in 0..3) {
            toDoRepository.addTask(
                ToDoTaskEntity(
                    id = i,
                    title = "Title $i",
                    description = "Description $i",
                    priority = Priority.values().find { it.ordinal == i } ?: Priority.NONE
                )
            )
        }
        val targetTaskId = 1
        val selectedTask = getSelectedTaskUseCase(taskId = targetTaskId).first()
        assert(selectedTask.id == targetTaskId)
    }

    @Test
    fun getSelectedTask_newToDoTaskIsRetrieved_returnsTrue() = runBlocking {
        val selectedTask = getSelectedTaskUseCase(taskId = Constants.ADD_TASK_ID).first()
        assert(selectedTask == ToDoTask.NewToDoTask)
    }
}