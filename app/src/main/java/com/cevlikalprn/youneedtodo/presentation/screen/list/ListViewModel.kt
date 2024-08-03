package com.cevlikalprn.youneedtodo.presentation.screen.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.common.Constants
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import com.cevlikalprn.youneedtodo.domain.useCase.GetAllTasksUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.SearchDatabaseUseCase
import com.cevlikalprn.youneedtodo.presentation.model.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val searchDatabaseUseCase: SearchDatabaseUseCase,
    private val appDispatchers: AppDispatchers
) : ViewModel() {

    var searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf(Constants.EMPTY_STRING)

    private val _allTasks: MutableStateFlow<ListUiState> = MutableStateFlow(ListUiState.Default)
    val allTasks: StateFlow<ListUiState> = _allTasks

    init {
        getAllTasks()
    }

    fun updateErrorMessage(message: String?) {
        _allTasks.update { it.copy(errorMessage = message) }
    }

    fun getAllTasks(priority: Priority = Priority.NONE) {
        viewModelScope.launch(appDispatchers.io) {
            getAllTasksUseCase(priority)
                .catch {
                    updateErrorMessage(it.message)
                }
                .collect { toDoTaskList ->
                    _allTasks.update { state ->
                        state.copy(
                            areTasksFetched = true,
                            toDoTasks = toDoTaskList
                        )
                    }
                }
        }
    }

    fun deleteAllTasks() {
        viewModelScope.launch {
            toDoRepository.deleteAllTasks()
        }
    }

    fun searchDatabase() {
        viewModelScope.launch(appDispatchers.io) {
            searchDatabaseUseCase(searchTextState.value)
                .catch {
                    updateErrorMessage(it.message)
                }
                .collect { toDoTaskList ->
                    _allTasks.update { state ->
                        state.copy(
                            areTasksFetched = true,
                            toDoTasks = toDoTaskList
                        )
                    }
                }
        }
    }

    fun updateSearchAppBarState(state: SearchAppBarState) {
        searchAppBarState.value = state
    }

    fun updateSearchTextState(text: String) {
        searchTextState.value = text
    }
}