package com.cevlikalprn.youneedtodo.domain.repository

import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import kotlinx.coroutines.flow.Flow

interface ToDoRepository : AppRepository {

    /*
     * Get all ToDoTaskEntity
     */
    suspend fun getAllTasks(): List<ToDoTaskEntity>?

    /*
     * Get selected ToDoTaskEntity by taskId
     */
    suspend fun getSelectedTask(taskId: Int): ToDoTaskEntity?

    /*
     * Get all ToDoTaskEntity sorted by low priority
     */
    suspend fun getSortedByLowPriority(): List<ToDoTaskEntity>

    /*
     * Get all ToDoTaskEntity sorted by high priority
     */
    suspend fun getSortedByHighPriority(): List<ToDoTaskEntity>

    /*
     * Add a ToDoTaskEntity
     */
    suspend fun addTask(todoTaskEntity: ToDoTaskEntity)

    /*
     * Update a ToDoTaskEntity
     */
    suspend fun updateTask(todoTaskEntity: ToDoTaskEntity)

    /*
     * Delete a ToDoTaskEntity
     */
    suspend fun deleteTask(todoTaskEntity: ToDoTaskEntity)

    /*
    * Delete all ToDoTaskEntity
    */
    suspend fun deleteAllTasks()

    /*
     * Get all searched ToDoTaskEntity
     */
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTaskEntity>>
}
