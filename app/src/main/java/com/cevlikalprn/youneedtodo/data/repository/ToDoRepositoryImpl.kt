package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao,
    private val externalScope: CoroutineScope,
    private val appDispatchers: AppDispatchers
) : ToDoRepository {

    override fun getAllTasks(): Flow<List<ToDoTaskEntity>?> {
        return todoDao.getAllTasks().flowOn(appDispatchers.io)
    }

    override fun getSelectedTask(taskId: Int): Flow<ToDoTaskEntity?> {
        return todoDao.getSelectedTask(taskId).flowOn(appDispatchers.io)
    }

    override fun getSortedByLowPriority(): Flow<List<ToDoTaskEntity>> {
        return todoDao.sortByLowPriority().flowOn(appDispatchers.io)
    }

    override fun getSortedByHighPriority(): Flow<List<ToDoTaskEntity>> {
        return todoDao.sortByHighPriority().flowOn(appDispatchers.io)
    }

    override suspend fun addTask(todoTaskEntity: ToDoTaskEntity) {
        externalScope.launch(appDispatchers.io) {
            todoDao.addTask(todoTaskEntity)
        }.join()
    }

    override suspend fun updateTask(todoTaskEntity: ToDoTaskEntity) {
        externalScope.launch(appDispatchers.io) {
            todoDao.updateTask(todoTaskEntity)
        }.join()
    }

    override suspend fun deleteTask(todoTaskEntity: ToDoTaskEntity) {
        externalScope.launch(appDispatchers.io) {
            todoDao.deleteTask(todoTaskEntity)
        }.join()
    }

    override suspend fun deleteAllTasks() {
        withContext(appDispatchers.io) {
            todoDao.deleteAllTasks()
        }
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTaskEntity>> {
        return todoDao.searchDatabase(searchQuery).flowOn(appDispatchers.io)
    }
}
