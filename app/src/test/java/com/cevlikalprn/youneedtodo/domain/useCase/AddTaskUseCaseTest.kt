package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddTaskUseCaseTest {

    private lateinit var toDoRepository: FakeToDoRepository
    private lateinit var addTaskUseCase: AddTaskUseCase

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        addTaskUseCase = AddTaskUseCase(
            toDoRepository = toDoRepository,
            taskEntityMapper = TaskEntityMapper()
        )
    }

    /*
    The given ID is ignored in TaskEntityMapper.
    In the mapper, the id of the data converted to ToDoTaskEntity is created automatically.
    Therefore title and description are checked .
    */
    @Test
    fun `Add Task`() = runBlocking {
        val taskToAdd = ToDoTask(
            id = 1,
            title = "New Task Title",
            "New task description",
            priority = Priority.HIGH
        )
        addTaskUseCase(taskToAdd)

        toDoRepository.getAllTasks().collectLatest {
            val addedTask = it?.firstOrNull()
            assert(taskToAdd.title == addedTask?.title)
            assert(taskToAdd.description == addedTask?.description)
        }
    }
}