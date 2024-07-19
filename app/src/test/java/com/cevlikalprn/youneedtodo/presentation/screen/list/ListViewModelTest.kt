package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.useCase.GetAllTasksUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.SearchDatabaseUseCase
import com.cevlikalprn.youneedtodo.presentation.model.SearchAppBarState
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ListViewModelTest {

    private lateinit var viewModel: ListViewModel

    private lateinit var toDoRepository: FakeToDoRepository

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        viewModel = ListViewModel(
            FakeToDoRepository(),
            GetAllTasksUseCase(toDoRepository, TaskListMapper()),
            SearchDatabaseUseCase(toDoRepository, TaskListMapper()),
            AppDispatchers(IO = TestCoroutineDispatcher())
        )
    }

    @Test
    fun getAllTasks_whenNewTaskAdded_thenTaskListIsNotEmpty() = runTest {
        toDoRepository.addTask(
            ToDoTaskEntity(
                1,
                "",
                "",
                Priority.NONE
            )
        )
        val tasks = viewModel.allTasks.value.toDoTasks
        assert(tasks?.isNotEmpty() == true)
    }

    @Test
    fun getAllTasks_whenViewModelInitialized_thenTasksAreFetched() {
        val areTasksFetched = viewModel.allTasks.value.areTasksFetched
        assert(areTasksFetched)
    }

    @Test
    fun getAllTasks_whenErrorReceived_thenErrorMessageUpdated() {
        val throwable = Throwable("Something went wrong")
        toDoRepository.setThrowable(throwable)
        viewModel.getAllTasks()
        val errorMessage = viewModel.allTasks.value.errorMessage
        assert(errorMessage == throwable.message)
    }

    @Test
    fun getAllTasks_whenPrioritySetToHigh_thenToDoListSortedByHighPriority() = runTest {
        val tasksToAdd = mutableListOf<ToDoTaskEntity>()
        for (i in 0..2) {
            tasksToAdd.add(
                ToDoTaskEntity(
                    i,
                    "",
                    "",
                    Priority.values()[i]
                )
            )
        }
        tasksToAdd.shuffle()
        tasksToAdd.forEach {
            toDoRepository.addTask(it)
        }
        viewModel.getAllTasks(priority = Priority.HIGH)
        val todoTasks = viewModel.allTasks.value.toDoTasks!!
        for (i in 0..todoTasks.size - 2) {
            assertEquals(true, todoTasks[i].priority.ordinal < todoTasks[i + 1].priority.ordinal)
        }
    }

    @Test
    fun getAllTasks_whenPrioritySetToLow_thenToDoListSortedByLowPriority() = runTest {
        val tasksToAdd = mutableListOf<ToDoTaskEntity>()
        for (i in 0..2) {
            tasksToAdd.add(
                ToDoTaskEntity(
                    i,
                    "",
                    "",
                    Priority.values()[i]
                )
            )
        }
        tasksToAdd.shuffle()
        tasksToAdd.forEach {
            toDoRepository.addTask(it)
        }
        viewModel.getAllTasks(priority = Priority.LOW)
        val todoTasks = viewModel.allTasks.value.toDoTasks!!
        for (i in 0..todoTasks.size - 2) {
            assertEquals(true, todoTasks[i].priority.ordinal > todoTasks[i + 1].priority.ordinal)
        }
    }

    @Test
    fun searchDatabase_whenQueryingWithText_thenToDoListSearchedByQuery() = runTest {
        val sampleTask = ToDoTaskEntity(1, "alp", "alperen", Priority.LOW)
        val sampleTask2 = ToDoTaskEntity(2, "alper", "eren", Priority.LOW)
        toDoRepository.addTask(sampleTask)
        toDoRepository.addTask(sampleTask2)
        viewModel.updateSearchTextState("alperen")
        viewModel.searchDatabase()
        val tasks = viewModel.allTasks.value.toDoTasks
        assert(tasks?.size == 1 && tasks.first().title == sampleTask.title)
    }

    @Test
    fun searchDatabase_whenErrorReceived_thenErrorMessageUpdated() {
        val throwable = Throwable("Something went wrong")
        toDoRepository.setThrowable(throwable)
        viewModel.searchDatabase()
        val errorMessage = viewModel.allTasks.value.errorMessage
        assert(errorMessage == throwable.message)
    }

    @Test
    fun updateErrorMessage_whenErrorReceived_thenUpdateErrorMessage() {
        val errorMessage = "Invalid Error"
        viewModel.updateErrorMessage(errorMessage)
        assertEquals(errorMessage, viewModel.allTasks.value.errorMessage)
    }

    @Test
    fun updateSearchAppBarState_whenStateChanged_thenStateUpdated() {
        val initialValue = SearchAppBarState.CLOSED
        val targetValue = SearchAppBarState.OPENED
        viewModel.searchAppBarState.value = initialValue
        viewModel.updateSearchAppBarState(targetValue)
        assert(viewModel.searchAppBarState.value == targetValue)
    }

    @Test
    fun updateSearchTextState_whenTextChanged_thenStateUpdated() {
        val initialValue = "initial"
        val targetValue = "target"
        viewModel.searchTextState.value = initialValue
        viewModel.updateSearchTextState(targetValue)
        assert(viewModel.searchTextState.value == targetValue)
    }
}