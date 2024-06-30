package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.Constants
import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import kotlinx.coroutines.flow.collectLatest
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

        runBlocking {
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
        }
    }

    @Test
    fun `Get selected task`() = runBlocking {
        val targetTaskId = 1
        getSelectedTaskUseCase(taskId = targetTaskId).collectLatest {
            assert(it.id == targetTaskId)
        }
    }

    @Test
    fun `Get New To Do Task`() = runBlocking {
        getSelectedTaskUseCase(taskId = Constants.ADD_TASK_ID).collectLatest {
            assert(it == ToDoTask.NewToDoTask)
        }
    }
}