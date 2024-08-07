package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.data.repository.FakeToDoRepository
import com.cevlikalprn.youneedtodo.domain.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UpdateTaskUseCaseTest {

    private lateinit var toDoRepository: FakeToDoRepository
    private lateinit var updateTaskUseCase: UpdateTaskUseCase

    private val taskId = 1

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        updateTaskUseCase = UpdateTaskUseCase(
            toDoRepository = toDoRepository,
            taskEntityMapper = TaskEntityMapper()
        )

        val taskToAdd = ToDoTaskEntity(
            id = taskId,
            title = "New Task Title",
            description = "New task description",
            priority = Priority.HIGH
        )

        runBlocking {
            toDoRepository.addTask(taskToAdd)
        }
    }

    @Test
    fun updateTask_updatedTaskIsInTheList_returnsTrue() = runBlocking {
        val updatedTaskTitle = "Updated Task Title"
        val updatedTaskDescription = "Updated Task Description"
        val updatedPriority = Priority.LOW

        updateTaskUseCase(
            ToDoTask(
                id = taskId,
                title = updatedTaskTitle,
                description = updatedTaskDescription,
                priority = updatedPriority
            )
        )

        val selectedTask = toDoRepository.getSelectedTask(taskId).first()
        assert(
            selectedTask?.title == updatedTaskTitle &&
                    selectedTask.description == updatedTaskDescription &&
                    selectedTask.priority == updatedPriority
        )
    }
}