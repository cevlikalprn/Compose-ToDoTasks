package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.useCase.GetAllTasksUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.SearchDatabaseUseCase
import com.cevlikalprn.youneedtodo.presentation.model.SearchAppBarState
import org.junit.Before
import org.junit.Test

class ListViewModelTest {

    private lateinit var viewModel: ListViewModel

    private lateinit var fakeToDoRepository: FakeToDoRepository

    @Before
    fun setUp() {
        fakeToDoRepository = FakeToDoRepository()
        viewModel = ListViewModel(
            FakeToDoRepository(),
            GetAllTasksUseCase(fakeToDoRepository, TaskListMapper()),
            SearchDatabaseUseCase(fakeToDoRepository, TaskListMapper())
        )
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