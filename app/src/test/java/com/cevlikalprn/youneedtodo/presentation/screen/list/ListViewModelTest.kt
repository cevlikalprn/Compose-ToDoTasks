package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.useCase.GetAllTasksUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.SearchDatabaseUseCase
import com.cevlikalprn.youneedtodo.presentation.model.SearchAppBarState
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
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
    fun getAllTasks_whenNewTaskAdded_thenTaskListIsNotEmpty() = runBlocking {
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
    fun getAllTasks_whenErrorReceived_thenUpdateErrorMessage() {
        val throwable = Throwable("Something went wrong")
        toDoRepository.setThrowable(throwable)
        viewModel.getAllTasks()
        val errorMessage = viewModel.allTasks.value.errorMessage
        assert(errorMessage == throwable.message)
    }


    @Test
    fun `updateSearchAppBarState updates the searchAppBarState successfully`() {
        val initialValue = SearchAppBarState.CLOSED
        val targetValue = SearchAppBarState.OPENED
        viewModel.searchAppBarState.value = initialValue
        viewModel.updateSearchAppBarState(targetValue)
        assert(viewModel.searchAppBarState.value == targetValue)
    }

    @Test
    fun `updateSearchTextState updates the searchTextState successfully`() {
        val initialValue = "initial"
        val targetValue = "target"
        viewModel.searchTextState.value = initialValue
        viewModel.updateSearchTextState(targetValue)
        assert(viewModel.searchTextState.value == targetValue)
    }
}