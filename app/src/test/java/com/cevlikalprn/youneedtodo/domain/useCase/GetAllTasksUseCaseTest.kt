package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.data.repository.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.repository.ToDoRepository
import com.cevlikalprn.youneedtodo.domain.mapper.TaskListMapper
import kotlinx.coroutines.flow.first
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
    fun getAllTasks_tasksAreSortedByLowPriority_returnsTrue() = runBlocking {
        val sortedTasksByLowPriority = getAllTaskUseCase(Priority.LOW)
        val tasks = sortedTasksByLowPriority.first()
        for (i in 0..tasks.size - 2) {
            val priorityOfCurrentItem = tasks[i].priority
            val priorityOfNextTask = tasks[i + 1].priority
            assert(priorityOfCurrentItem.ordinal >= priorityOfNextTask.ordinal)
        }
    }

    @Test
    fun getAllTasks_tasksAreSortedByHighPriority_returnsTrue() = runBlocking {
        val sortedTasksByHighPriority = getAllTaskUseCase(Priority.HIGH)
        val tasks = sortedTasksByHighPriority.first()
        for (i in 0..tasks.size - 2) {
            val priorityOfCurrentItem = tasks[i].priority
            val priorityOfNextTask = tasks[i + 1].priority
            assert(priorityOfCurrentItem.ordinal <= priorityOfNextTask.ordinal)
        }
    }


    @Test
    fun getAllTasks_tasksAreInDescendingOrderById_returnsTrue() = runBlocking {
        val allTasks = getAllTaskUseCase(Priority.NONE)
        val tasks = allTasks.first()
        for (i in 0..tasks.size - 2) {
            val currentTaskId = tasks[i].id
            val nextTaskId = tasks[i + 1].id
            assert(currentTaskId > nextTaskId)
        }
    }
}