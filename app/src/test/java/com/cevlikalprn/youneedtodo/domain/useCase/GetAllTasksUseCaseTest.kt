package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllTasksUseCaseTest {

    private lateinit var toDoRepository: ToDoRepository
    private lateinit var getAllTaskUseCase: GetAllTasksUseCase

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        getAllTaskUseCase = GetAllTasksUseCase(
            toDoRepository = toDoRepository,
            taskListMapper = TaskListMapper()
        )

        val createdNotes = mutableListOf<ToDoTaskEntity>()

        for (i in 0..2) {
            createdNotes.add(
                ToDoTaskEntity(
                    id = i,
                    title = "Title $i",
                    description = "Description $i",
                    priority = Priority.values().find { it.ordinal == i }!!
                )
            )
        }

        createdNotes.shuffle()

        runBlocking {
            createdNotes.forEach {
                toDoRepository.addTask(it)
            }
        }
    }

    @Test
    fun `Get sorted tasks by low priority`() = runBlocking {
        val sortedTasksByLowPriority = getAllTaskUseCase(Priority.LOW)
        sortedTasksByLowPriority.collectLatest { tasks ->
            for (i in 0..tasks.size - 2) {
                val priorityOfCurrentItem = tasks[i].priority
                val priorityOfNextTask = tasks[i + 1].priority
                assert(priorityOfCurrentItem.ordinal >= priorityOfNextTask.ordinal)
            }
        }
    }

    @Test
    fun `Get sorted task by high priority`() = runBlocking {
        val sortedTasksByHighPriority = getAllTaskUseCase(Priority.HIGH)
        sortedTasksByHighPriority.collectLatest { tasks ->
            for (i in 0..tasks.size - 2) {
                val priorityOfCurrentItem = tasks[i].priority
                val priorityOfNextTask = tasks[i + 1].priority
                assert(priorityOfCurrentItem.ordinal <= priorityOfNextTask.ordinal)
            }
        }
    }


    @Test
    fun `Get all tasks, descending by id`() = runBlocking {
        val allTasks = getAllTaskUseCase(Priority.NONE)
        allTasks.collectLatest { tasks ->
            for (i in 0..tasks.size - 2) {
                val currentTaskId = tasks[i].id
                val nextTaskId = tasks[i + 1].id
                assert(currentTaskId > nextTaskId)
            }
        }
    }
}