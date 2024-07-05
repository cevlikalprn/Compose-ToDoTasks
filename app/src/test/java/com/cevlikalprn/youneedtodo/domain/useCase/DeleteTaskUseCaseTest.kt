package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteTaskUseCaseTest {


    private lateinit var toDoRepository: FakeToDoRepository
    private lateinit var deleteTaskUseCase: DeleteTaskUseCase

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        deleteTaskUseCase = DeleteTaskUseCase(
            toDoRepository = toDoRepository,
            toDoTaskEntityMapper = TaskEntityMapper()
        )
    }

    @Test
    fun `Delete a Task`() = runBlocking {
        val addedTask = ToDoTaskEntity(
            id = 0,
            title = "new title",
            description = "new description",
            priority = Priority.NONE
        )
        toDoRepository.addTask(addedTask)

        deleteTaskUseCase(
            ToDoTask(
                id = addedTask.id,
                title = addedTask.title,
                description = addedTask.description,
                priority = addedTask.priority
            )
        )

        val task = toDoRepository.getSelectedTask(0).first()
        assert(task == null)
    }
}
