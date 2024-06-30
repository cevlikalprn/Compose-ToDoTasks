package com.cevlikalprn.youneedtodo.data

import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeToDoRepository : ToDoRepository {

    private val toDoList = mutableListOf<ToDoTaskEntity>()

    override fun getAllTasks(): Flow<List<ToDoTaskEntity>?> {
        return flow { emit(toDoList.sortedByDescending { it.id }) }
    }

    override fun getSelectedTask(taskId: Int): Flow<ToDoTaskEntity?> {
        return flow { emit(toDoList.find { it.id == taskId }) }
    }

    override fun getSortedByLowPriority(): Flow<List<ToDoTaskEntity>> {
        return flow {
            emit(toDoList.sortedByDescending { it.priority.ordinal })
        }
    }

    override fun getSortedByHighPriority(): Flow<List<ToDoTaskEntity>> {
        return flow {
            emit(toDoList.sortedBy { it.priority.ordinal })
        }
    }

    override suspend fun addTask(todoTaskEntity: ToDoTaskEntity) {
        toDoList.add(todoTaskEntity)
    }

    override suspend fun updateTask(todoTaskEntity: ToDoTaskEntity) {
        val targetIndex = toDoList.indexOfFirst { it.id == todoTaskEntity.id }
        toDoList[targetIndex] = todoTaskEntity
    }

    override suspend fun deleteTask(todoTaskEntity: ToDoTaskEntity) {
        toDoList.remove(todoTaskEntity)
    }

    override suspend fun deleteAllTasks() {
        toDoList.clear()
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTaskEntity>> {
        return flow {
            val filteredList = toDoList.filter {
                it.title.contains(searchQuery, true) || it.description.contains(
                    searchQuery,
                    true
                )
            }

            emit(filteredList)
        }
    }
}