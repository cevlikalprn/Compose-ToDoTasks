package com.cevlikalprn.youneedtodo.domain.repository

import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    /*
     * Get all ToDoTaskEntity
     */
    fun getAllTasks(): Flow<List<ToDoTaskEntity>?>

    /*
     * Get selected ToDoTaskEntity by taskId
     */
    fun getSelectedTask(taskId: Int): Flow<ToDoTaskEntity?>

    /*
     * Get all ToDoTaskEntity sorted by low priority
     */
    fun getSortedByLowPriority(): Flow<List<ToDoTaskEntity>>

    /*
     * Get all ToDoTaskEntity sorted by high priority
     */
    fun getSortedByHighPriority(): Flow<List<ToDoTaskEntity>>

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
