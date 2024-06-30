package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteTaskUseCaseTest {


    private lateinit var toDoRepository: FakeToDoRepository
    private lateinit var deleteTaskUseCase: DeleteTaskUseCase
    private lateinit var savedToDoTaskEntity: ToDoTaskEntity

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        deleteTaskUseCase = DeleteTaskUseCase(
            toDoRepository = toDoRepository,
            toDoTaskEntityMapper = TaskEntityMapper()
        )

        savedToDoTaskEntity = ToDoTaskEntity(
            id = 0,
            title = "new title",
            description = "new description",
            priority = Priority.NONE
        )

        runBlocking {
            toDoRepository.addTask(savedToDoTaskEntity)
        }
    }

    @Test
    fun `Delete a Task`() = runBlocking {
        deleteTaskUseCase(
            ToDoTask(
                id = savedToDoTaskEntity.id,
                title = savedToDoTaskEntity.title,
                description = savedToDoTaskEntity.description,
                priority = savedToDoTaskEntity.priority
            )
        )

        toDoRepository.getAllTasks().collectLatest {
            assert(it?.firstOrNull() != savedToDoTaskEntity)
        }
    }
}
