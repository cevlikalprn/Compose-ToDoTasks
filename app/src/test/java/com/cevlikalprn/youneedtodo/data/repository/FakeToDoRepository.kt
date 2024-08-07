package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class FakeToDoRepository : ToDoRepository {

    private val todoTasksFlow = MutableStateFlow<List<ToDoTaskEntity>>(emptyList())

    private var throwable: Throwable? = null

    fun setThrowable(throwable: Throwable) {
        this.throwable = throwable
    }

    private inline fun <T> handleExceptions(flowBlock: () -> Flow<T>): Flow<T> {
        throwable?.let {
            return flow { throw throwable!! }
        }
        return flowBlock()
    }

    override fun getAllTasks(): Flow<List<ToDoTaskEntity>?> {
        return handleExceptions {
            todoTasksFlow.map { tasks -> tasks.sortedByDescending { it.id } }
        }
    }

    override fun getSelectedTask(taskId: Int): Flow<ToDoTaskEntity?> {
        return handleExceptions {
            todoTasksFlow.map { tasks -> tasks.find { it.id == taskId } }
        }
    }

    override fun getSortedByLowPriority(): Flow<List<ToDoTaskEntity>> {
        return handleExceptions {
            todoTasksFlow.map { tasks -> tasks.sortedByDescending { it.priority.ordinal } }
        }
    }

    override fun getSortedByHighPriority(): Flow<List<ToDoTaskEntity>> {
        return handleExceptions {
            todoTasksFlow.map { tasks -> tasks.sortedBy { it.priority.ordinal } }
        }
    }

    override suspend fun addTask(todoTaskEntity: ToDoTaskEntity) {
        todoTasksFlow.update { tasks -> tasks + todoTaskEntity }
    }

    override suspend fun updateTask(todoTaskEntity: ToDoTaskEntity) {
        todoTasksFlow.update { tasks -> tasks.map { if (it.id == todoTaskEntity.id) todoTaskEntity else it } }
    }

    override suspend fun deleteTask(todoTaskEntity: ToDoTaskEntity) {
        todoTasksFlow.update { tasks -> tasks.filter { it.id != todoTaskEntity.id } }
    }

    override suspend fun deleteAllTasks() {
        todoTasksFlow.update { emptyList() }
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTaskEntity>> {
        return handleExceptions {
            todoTasksFlow.map { tasks ->
                tasks.filter {
                    it.title.contains(searchQuery, true) || it.description.contains(
                        searchQuery,
                        true
                    )
                }
            }
        }
    }
}