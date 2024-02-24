package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : ToDoRepository {

    override suspend fun getAllTasks(): List<ToDoTaskEntity>? {
        return todoDao.getAllTasks()
    }

    override suspend fun getSelectedTask(taskId: Int): ToDoTaskEntity? {
        return todoDao.getSelectedTask(taskId)
    }

    override fun getSortedByLowPriority(): Flow<List<ToDoTaskEntity>> {
        return todoDao.sortByLowPriority()
    }

    override fun getSortedByHighPriority(): Flow<List<ToDoTaskEntity>> {
        return todoDao.sortByHighPriority()
    }

    override suspend fun addTask(todoTaskEntity: ToDoTaskEntity) {
        todoDao.addTask(todoTaskEntity)
    }

    override suspend fun updateTask(todoTaskEntity: ToDoTaskEntity) {
        todoDao.updateTask(todoTaskEntity)
    }

    override suspend fun deleteTask(todoTaskEntity: ToDoTaskEntity) {
        todoDao.deleteTask(todoTaskEntity)
    }

    override suspend fun deleteAllTasks(): Int {
        return todoDao.deleteAllTasks()
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTaskEntity>> {
        return todoDao.searchDatabase(searchQuery)
    }
}
